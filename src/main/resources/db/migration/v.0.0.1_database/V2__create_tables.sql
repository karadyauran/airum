create table users
(
    id            uuid primary key,
    username      varchar(40) unique  not null,
    firstname     varchar(40)         not null,
    surname       varchar(40)         not null,
    email         varchar(120) unique not null,
    password      varchar(72)         not null,
    registered_at timestamp default now()
);

create table notifications
(
    id       uuid primary key,
    sender   uuid references users (id) on delete cascade on update cascade not null,
    receiver uuid references users (id) on delete cascade on update cascade not null,
    message  text                                                           not null,
    sent_at  timestamp default now()
);

create table projects
(
    id          uuid primary key,
    creator_id  uuid references users (id) on delete cascade not null,
    name        varchar(60)                                  not null,
    description text                                         not null,
    created_at  timestamp default now()
);

create table roles
(
    id         uuid primary key,
    name       varchar(20)                                                       not null,
    project_id uuid references projects (id) on delete cascade on update cascade not null
);

create table user_projects
(
    user_id    uuid references users (id) on delete cascade on update cascade    not null,
    project_id uuid references projects (id) on delete cascade on update cascade not null,
    role_id    uuid references roles (id) on delete cascade on update cascade    not null
);

create table tasks
(
    id          uuid primary key,
    project_id  uuid references projects (id) on delete cascade on update cascade,
    title       varchar(60)                                                    not null,
    description text                                                           not null,
    status      varchar(30) default 'IN_PROGRESS',
    assigned_to uuid references users (id) on delete cascade on update cascade not null,
    created_by  uuid references users (id) on delete cascade on update cascade not null,
    due_to      date,
    created_at  timestamp   default now()
);

create table attachments
(
    id      uuid primary key,
    name    varchar(30)                                                    not null,
    path    varchar(200)                                                   not null,
    task_id uuid references tasks (id) on delete cascade on update cascade not null,
    user_id uuid references users (id) on delete cascade on update cascade not null
);

create table comments
(
    id         uuid primary key,
    task       uuid references tasks (id) on delete cascade on update cascade not null,
    user_id    uuid references users (id) on delete cascade on update cascade not null,
    comment    text                                                           not null,
    created_at timestamp default now()
);


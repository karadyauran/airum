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
    id         uuid primary key,
    user_id    uuid references users (id) on delete cascade on update cascade    not null,
    project_id uuid references projects (id) on delete cascade on update cascade not null,
    role_id    uuid references roles (id) on delete cascade on update cascade
);

create table tasks
(
    id          uuid primary key,
    project_id  uuid references projects (id) on delete cascade on update cascade not null,
    title       varchar(60)                                                       not null,
    description text                                                              not null,
    status      varchar(30) default 'IN_PROGRESS',
    assigned_to uuid references users (id) on delete cascade on update cascade    not null,
    created_by  uuid references users (id) on delete cascade on update cascade    not null,
    due_to      date,
    created_at  timestamp   default now()
);

create table comments
(
    id         uuid primary key,
    task_id    uuid references tasks (id) on delete cascade on update cascade not null,
    user_id    uuid references users (id) on delete cascade on update cascade not null,
    comment    text                                                           not null,
    changed    boolean   default false,
    created_at timestamp default now()
);


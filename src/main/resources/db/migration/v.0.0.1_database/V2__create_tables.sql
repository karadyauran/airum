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

create table roles
(
    id   uuid primary key,
    name varchar(20) unique
);

create table notifications
(
    id         uuid primary key,
    sender     uuid references users (id) not null,
    receiver   uuid references users (id) not null,
    message    text                       not null,
    created_at timestamp default now()
);

create table project_members
(
    id         uuid primary key,
    user_id    uuid references users (id) not null,
    role_id    uuid references roles (id),
    created_at timestamp default now()
);

create table projects
(
    id          uuid primary key,
    user_id     uuid references users (id) not null,
    name        varchar(60)                not null,
    description text                       not null,
    created_at  timestamp default now()
);

create table user_projects
(
    user_id    uuid not null,
    project_id uuid not null
);

create table tasks
(
    id          uuid primary key,
    project_id  uuid references projects (id),
    title       varchar(60)                not null,
    description text                       not null,
    status      varchar(30) default 'IN_PROGRESS',
    assigned_to uuid references users (id) not null,
    created_by  uuid references users (id) not null,
    due_to      date,
    created_at  timestamp   default now()
);

create table attachments
(
    id      uuid primary key,
    name    varchar(30)                not null,
    path    varchar(200)               not null,
    task    uuid references tasks (id) not null,
    user_id uuid references users (id) not null
);

create table comments
(
    id         uuid primary key,
    task       uuid references tasks (id) not null,
    user_id    uuid references users (id) not null,
    comment    text                       not null,
    created_at timestamp default now()
);


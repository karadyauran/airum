create table users (
    id              uuid primary key,
    username        varchar(40) unique not null,
    firstname       varchar(40) not null,
    surname         varchar(40) not null,
    email           varchar(120) unique not null,
    password        varchar(72) not null,
    registered_at   timestamp default now()
);
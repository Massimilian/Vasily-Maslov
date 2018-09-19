create database UML_systems;

create table note (
id serial primary key,
name varchar(20),
information text
);

create table attach (
id serial primary key,
name varchar(20),
information text
);

create table state (
id serial primary key,
is_made boolean,
remark text
);

create table category (
id serial primary key,
name varchar(20),
decription text
);

create table rules (
id serial primary key,
name varchar(20)
);

create table roles (
id serial primary key,
name varchar(30),
description text,
rules_id int references rules(id)
);

create table users (
id serial primary key,
name varchar(30),
roles_id integer references roles(id)
);

create table item (
id serial primary key,
name varchar(20),
users_id int references users(id),
comment_id int references note(id),
attach_id int references attach(id),
category_id int references category(id),
state_is_id int references state(id)
);


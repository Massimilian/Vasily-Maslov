create database car_factory;

create table transmission (
id serial primary key,
name varchar(50),
info text
);

create table car_body (
id serial primary key,
name varchar(50),
info text
);

create table engine (
id serial primary key,
name varchar (50),
strength double precision,
info text
);

create table car (
id serial primary key,
name varchar(50),
transmission_id integer references transmission(id),
car_body_id integer references car_body(id),
engine_id integer references engine(id),
info text
);
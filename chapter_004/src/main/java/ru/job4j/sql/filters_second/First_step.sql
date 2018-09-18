create table product (
id serial primary key,
name varchar(30),
type_id int,
expired_date date,
price double precision
);

create table type(
id serial primary key,
name text
);
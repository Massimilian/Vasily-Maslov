alter table product add column number_of_products int;
select * from product where number_of_products < 10;
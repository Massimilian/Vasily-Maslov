
select * from product where 
type_id=(select id from type where name='СЫР') 
or type_id=(select id from type where name='МОЛОКО');

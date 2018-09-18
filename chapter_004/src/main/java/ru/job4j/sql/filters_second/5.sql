select product.type_id, count(*) from product
where type_id = (select id from type where type.name = 
-- здесь может быть любой продукт
'СЫР')
group by product.type_id;
 
select * from product 
inner join type on product.type_id = type.id 
where type.name = 'СЫР';

-- Использование слова join
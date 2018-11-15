select name from company where id in (select company_id from person group by company_id order by count(company_id) desc limit 1);


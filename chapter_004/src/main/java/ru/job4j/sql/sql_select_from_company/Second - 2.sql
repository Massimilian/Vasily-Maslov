﻿select count(company_id) from person where company_id in(select company_id from person group by company_id order by count(company_id) desc limit 1);
select vendors.vend_id, vend_name, prod_name, prod_price, products.vend_id
from vendors, products;

select vendors.vend_id, vend_name, prod_name, prod_price, products.vend_id, vend_state
from vendors, products
where vendors.vend_id = products.vend_id
and vend_state='CA';

select prod_name, vend_name, prod_price, quantity
from OrderItems, products, vendors
where products.vend_id = vendors.vend_id
order by quantity
and orderitems.prod_id=products.prod_id
and order_num=20007;

select vend_name, avg(prod_price) as avg_price , avg(quantity) as avg_quantity
from OrderItems, products, vendors
group by vend_name, prod_price, quantity
and order_num = 20007;

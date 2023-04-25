select prod_id, quantity, item_price
from orderitems
where order_num = 20007;

select products.prod_id, orderitems.quantity, orderitems.item_price, orderitems.order_num
from orderitems, products
where products.prod_id = orderitems.prod_id
and order_num=20007;

select vendors.vend_name, products.prod_id, orderitems.quantity, orderitems.item_price
from orderitems, products, vendors
where products.vend_id = vendors.vend_id
and products.prod_id=orderitems.prod_id
and order_num=20007;
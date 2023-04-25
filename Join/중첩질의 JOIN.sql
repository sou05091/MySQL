select cust_name, cust_contact
from customers
where cust_id
	in(select cust_id
	from orders
    where order_num in(select order_num
						from orderitems
                        where prod_id='RGAN01'));

select cust_name, cust_contact
from customers, orders, orderitems
where customers.cust_id=orders.cust_id
and orderitems.order_num=orders.order_num
and prod_id='RGAN01';

select cust_name, cust_contact
from customers
join orders using(cust_id)
join orderitems using(order_num)
where prod_id = 'RGAN01';
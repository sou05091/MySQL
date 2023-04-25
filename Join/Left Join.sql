select customers.cust_id, orders.order_num
from customers, orders
where customers.cust_id=orders.cust_id;
/*join*/
select customers.cust_id, orders.order_num
from customers
left outer join orders
on customers.cust_id = orders.cust_id;
/*left join*/
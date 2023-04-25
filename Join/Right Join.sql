select customers.cust_id, orders.order_num
from customers, orders
where customers.cust_id=orders.cust_id;
/*join*/
select customers.cust_id,orders.order_num
from customers
right outer join orders
on customers.cust_id=orders.cust_id;
/*right join, leftjoin에서 위치만 바뀐다고 생각*/
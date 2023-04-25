SELECT year, mon, count(*)
FROM (SELECT YEAR(order_date) AS year, MONTH(order_date) AS mon
	FROM orders
	GROUP BY year, mon
	ORDER BY year, mon) AS YM, orders
WHERE YM.year=YEAR(orders.order_date) and YM.mon=MONTH(orders.order_date)
GROUP BY year, mon
ORDER BY year, mon;

SELECT YEAR(order_date) AS year, MONTH(order_date) AS mon, count(*)
FROM orders
GROUP BY year, mon
ORDER BY year, mon;

select cust_name, year(order_date) as year, month(order_date) as mon, count(*)
from orders, customers
where orders.cust_id=customers.cust_id
group by orders.cust_id, year, mon
order by orders.cust_id, year, mon;
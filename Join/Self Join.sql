select cust_id, cust_name, cust_contact
from customers
where cust_name = (select cust_name
					from customers
                    where cust_contact='Jim Jones');
                    
select c1.cust_id, c1.cust_name, c1.cust_contact
from customers as c1, customers as c2
where c1.cust_name = c2.cust_name
and c2.cust_contact='Jim Jones';

select cust_id, cust_name, cust_contact
from customers;
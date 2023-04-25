select cust_name, cust_contact, cust_email
from customers
where cust_state IN('IL', 'IN', 'MI')
union all
select cust_name, cust_contact, cust_email
from customers
where cust_name='Fun4All';

select cust_name, cust_contact, cust_email
from customers
where cust_state in ('IL', 'IN', 'MI')
or cust_name='Fun4All';
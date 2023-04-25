select cust_name, cust_contact, cust_email
from customers
where cust_state in ('IL','IN','MI');
select cust_name, cust_contact, cust_email
from customers
where cust_name='Fun4All';

select cust_name,cust_contact,cust_email, cust_state
from customers
where cust_state IN ('IL', 'IN', 'MI')
union
select cust_name, cust_contact, cust_email, cust_state
from customers
where cust_name='Fun4All';

select cust_name, cust_contact, cust_email
from customers
where cust_state in ('IL', 'IN', 'MI')
or cust_name='Fun4All';
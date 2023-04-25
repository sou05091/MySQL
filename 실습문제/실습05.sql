select sno, pno, jno, s.city
from s,p,j
where s.city = p.city = j.city;
select p.pno, p.pname,spj.sno
from s,p,spj,j
where s.city='London' and spj.sno = s.sno and j.city='London' and spj.jno = j.jno and spj.pno= p.pno;

select spj.jno, spj.sno, s.sname
from spj, s
where spj.sno = s.sno; 
/*sno 중첩되는 부분을 삭제*/
select spj.jno, spj.sno, s.sname
from spj, s
where spj.sno = s.sno and spj.jno = 'j1';
/*sno 중첩되는 부분을 삭제후 j1의 값만 출력*/
select spj.jno, spj.sno, s.sname
from spj, s
where spj.sno = s.sno and spj.jno = 'j2';
/*sno 중첩되는 부분을 삭제후 j2의 값만 출력*/
select distinct spj.jno, spj.sno, s.sname
from spj, s
where spj.sno = s.sno and spj.jno = 'j2';
/*sno 중첩되는 부분을 삭제후 j2의 값만 출력후 중첩되는 부분 삭제*/

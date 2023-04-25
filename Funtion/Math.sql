select Continent, Name, (Population/SurfaceArea) AS pd 
from Country order by pd desc, SurfaceArea desc;
select Continent, Name, SurfaceArea 
from Country where SurfaceArea = 0;
/*바로 연산해서 데이터 검색*/

select continent, count(*) as nation_count
from country
group by continent
having nation_count > 40;
select Continent, Count(*) as nation_count
from country
where population > 10000000
group by Continent
having nation_count >= 2;
select Continent, Count(*) as area
from country
where SurfaceArea>4000
group by Continent
having area>2;
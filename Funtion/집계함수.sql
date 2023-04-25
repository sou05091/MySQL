select avg(population), count(name), max(population), min(population), sum(population)
from country;
select count(*), avg(population), count(name), max(population), min(population), sum(population)
from country
where population>10000000;
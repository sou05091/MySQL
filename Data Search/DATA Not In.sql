SELECT Continent, Name, Population, GNP
FROM Country
WHERE NOT Continent IN ('Asia', 'Europe', 'Africa');
select Continent, Name, Population, GNP
from country
where code <>'Asia' and code <>'Europe' and code <> 'Africa';

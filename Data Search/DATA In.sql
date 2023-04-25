select Continent, Name, Population, GNP
from country
where Code in ('KOR', 'CHN','JPN');/*셋중 하나만 있더라도 포함*/
select Continent, Name, Population, GNP
from country
where Code='KOR' or Code='CHN' or Code='JPN'; /*위와 같은 의미인 코드*/
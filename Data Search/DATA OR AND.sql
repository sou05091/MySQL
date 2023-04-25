select Continent, Name, Population, GNP from Country where Population>100000000 and (GNP<100000);
SELECT Continent, Name, Population, GNP, GNPOld FROM Country WHERE Population>10000000 OR (GNP<100000 AND GNPOld IS NULL);
select Continent, Name, Population, GNP, GNPOld from country where (Population > 100000000 or GNP<100000) and GNPOld is null;
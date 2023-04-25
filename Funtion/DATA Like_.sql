select Continent, Name, Population, GNP from country where Continent Like 'A___'; 
select Name from country where Name Like 'A_g%';
select Name from country where Name Like 'A%B'; /*A도 해당 B도 해당*/
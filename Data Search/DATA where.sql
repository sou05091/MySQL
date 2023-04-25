select count(*) from city;
select * from city order by id desc limit 10; /*뒤에서 10개*/
select * from city order by id limit 11,10; /*11번부터 10개*/
select * from city order by id limit 21,10; /*21번부터 10개*/
select Continent, Name, Population from country where population>100000000;/*1억인구 이상만 조회*/
select Continent, Name, Population from country where population<>0 order by Population; /*<>같지 않을때*/
select Continent, Name, Population, GNP from country where population=0 order by GNP desc , Name desc;

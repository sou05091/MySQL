use sakila;
select concat(FIRST_NAME, " ", last_name) as name, actor_id as id, 
year (last_update) as y,
month (last_update) as m,
day (last_update) as d
from actor
limit 10;
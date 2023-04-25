select Name,upper(left(name,2)) as Alias,length(Name) as Len
from Country
order by Len desc
limit 10;
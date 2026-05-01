# Write your MySQL query statement below
select 
    x, y, z, 
    case
        when x > 0 and y > 0 and z > 0
        and x + y > z and y + z > x and z + x > y then 'Yes'
        else 'No' end
        as triangle
from Triangle
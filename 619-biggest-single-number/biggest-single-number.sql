# Write your MySQL query statement below
WITH single_number AS(
  SELECT num, count(num) as num_count
  FROM MyNumbers
  GROUP BY num
  HAVING count(num)=1
)

SELECT max(num) as num
FROM single_number
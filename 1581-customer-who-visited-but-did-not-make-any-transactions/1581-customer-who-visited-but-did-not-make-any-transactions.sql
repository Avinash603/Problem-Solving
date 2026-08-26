# Write your MySQL query statement below
SELECT v.customer_id,count(v.visit_id) as count_no_trans
FROM Visits v
LEFT JOIN Transactions T
ON v.visit_id= T.visit_id
WHERE T.transaction_id IS NULL
GROUP BY v.customer_id;
#jab v function use hota h count , avg ,sum y sab ko aggrgate function bolte h
#us function se pahle jo column ho use grop by m likhte h 

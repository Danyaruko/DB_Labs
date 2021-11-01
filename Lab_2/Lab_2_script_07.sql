SELECT DISTINCT CONVERT(time_in, date) as date, (SELECT COUNT(trip_no) FROM trip WHERE town_to = 'Moscow' GROUP BY CONVERT(time_in, date)) AS num_of_trips
FROM trip
ORDER BY num_of_trips
LIMIT 1;
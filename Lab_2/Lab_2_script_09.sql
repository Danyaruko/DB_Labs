SELECT trip.trip_no, company.name AS company_name, trip.plane, trip.town_from, trip.town_to, TIMEDIFF(time_in, time_out) AS trip_duration,
CASE 
   WHEN TIMEDIFF(time_in, time_out) <= 0 THEN 'Time of arrival is earlier than time of departure!'
END AS note
FROM trip
INNER JOIN company ON trip.ID_comp = company.ID_comp
ORDER BY trip_no;
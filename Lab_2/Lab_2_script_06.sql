SELECT trip_no, date, ID_psg, SUBSTRING(place, 1, 1) AS seat_row, SUBSTRING(place, -1, 1) AS seat_no
FROM pass_in_trip;
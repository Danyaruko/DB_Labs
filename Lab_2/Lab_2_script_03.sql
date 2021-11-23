SELECT * 
FROM company
LEFT JOIN trip ON company.ID_comp = trip.ID_comp
WHERE plane = 'Boeing';

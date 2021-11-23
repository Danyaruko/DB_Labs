SELECT 'PC' AS type, model, MIN(price) AS min_price
FROM pc
GROUP BY model
UNION
SELECT 'Laptop' AS type, model, MIN(price) AS min_price
FROM laptop
GROUP BY model
UNION 
SELECT 'Printer' AS type, model, MIN(price) AS min_price
FROM printer
GROUP BY model;
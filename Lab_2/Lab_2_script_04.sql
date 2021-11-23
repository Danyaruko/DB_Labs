SELECT COUNT(model), maker
FROM product
WHERE (type = 'PC' OR type = 'Laptop') AND maker = 'A'
GROUP BY maker;
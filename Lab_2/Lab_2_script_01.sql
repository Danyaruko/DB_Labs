SELECT model, speed, hd, cd, price
FROM pc WHERE (cd = '12x' OR cd = '24x') AND price < 600
ORDER BY speed DESC;
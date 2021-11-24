SELECT DISTINCT a.maker
FROM product a, product b
WHERE a.type ='Laptop' AND b.type ='Printer' AND a.maker = b.maker;
USE Patana_7_64;

SELECT * FROM student
WHERE overall_rating > student_average_overall_rating();

SELECT city_name,  `oblast'_retrieval`(`oblast'_id`) FROM city
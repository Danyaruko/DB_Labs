USE Patana_7_64;

CALL clear_tables();

CALL `insert_into_class`("IR-21","Internet Rechej 2 kurs 1 grupa", '2020-09-01');
CALL `insert_into_class`("KN-21","Komp'juterni Nauky 2 kurs 1 grupa", '2020-09-01');
CALL `insert_into_class`("IR-31","Internet Rechej 3 kurs 1 grupa", '2019-09-01');
CALL `insert_into_class`("IR-11","Internet Rechej 1 kurs 1 grupa", '2021-09-01');
CALL `insert_into_class`("IR-22","Internet Rechej 2 kurs 2 grupa", '2020-09-01');
CALL `insert_into_class`("KN-11","Komp'juterni Nauky 2 kurs 1 grupa", '2021-09-01');

CALL insert_into_city("L'viv", "46");
CALL insert_into_city("Kolomyya", "26");
CALL insert_into_city("Zhovkva", "46");
CALL insert_into_city("Makiyivka", "14");
CALL insert_into_city("Kobelyaky", "53");

CALL insert_into_finished_secondary_school("L'vivskyi Phizyco-Matematychnyy Licey","262-50-40","Dobosevych Mar'yan Stanislavovych","L'viv");
CALL insert_into_finished_secondary_school("Zagal'noosvitnya shkola №84","+380984534084","Grys'ko Anton Orestovych","L'viv");
CALL insert_into_finished_secondary_school("Zhovkiv'skyy Licey","262-43-34","Brzeszczynczykewycz Grzegorz Andriyevych","Zhovkva");
CALL insert_into_finished_secondary_school("Gymnaziya 'Krashanka'","+380504838573","Yayceva Vasylysa Petrivna","Kolomyya");
CALL insert_into_finished_secondary_school("Obscheobrazovatel'naya shkola №34","+380503483748","Guseva Anna Fyodorovna","Makiyivka");
CALL insert_into_finished_secondary_school("Kobelyats'ka Gymnaziya","+380880055535","Zhmyshenko Al'bert Valeriyovych","Kobelyaky");

CALL insert_into_academic_failure("High math");
CALL insert_into_academic_failure("Algoritmization and programming");
CALL insert_into_academic_failure("Web programming and design");
CALL insert_into_academic_failure("Organisation of data bases and structures");

CALL insert_into_student("A00000001A", "Danylo", "Patana", "Anatoliyovych", "2002-05-19", 
"2020-09-01", 47, "danilpatana1905@gmail.com", "IR-21", "L'viv", "L'vivskyi Phizyco-Matematychnyy Licey");
CALL insert_into_student("A00000012B", "Semen", "Generic", "The first", "2003-06-20", 
"2020-09-01", 56, "syomageneric2006@gmail.com", "IR-21", "L'viv", "Zagal'noosvitnya shkola №84");
CALL insert_into_student("A00000123C", "Pavlo", "Generic", "The second", "2001-04-18", 
"2021-09-01", 45, "pashageneric1804@gmail.com", "IR-21", "Kolomyya", "Gymnaziya 'Krashanka'");
CALL insert_into_student("A00001234D", "Georgy", "Generic", "The third", "2004-07-21", 
"2021-09-01", 74, "gayorgygeneric2107@gmail.com", "IR-21", "Zhovkva", "Zhovkiv'skyy Licey");
CALL insert_into_student("A00012345E", "Stepan", "Generic", "The fourth", "2002-05-19", 
"2020-09-01", 83, "styopageneric1905@gmail.com", "IR-21", "Makiyivka", "L'vivskyi Phizyco-Matematychnyy Licey");
CALL insert_into_student("A00123456F", "Svitlana", "Generic", "The fifth", "2000-03-17", 
"2019-09-01", 92, "svetageneric1703@gmail.com", "IR-21", "Kobelyaky", "Kobelyats'ka Gymnaziya");
CALL insert_into_student("A01234567G", "Nikifor", "Generic", "The sixth", "2002-08-22", 
"2020-09-01", 81, "nikiforgeneric2208@gmail.com", "IR-21", "L'viv", "L'vivskyi Phizyco-Matematychnyy Licey");
CALL insert_into_student("A12345678H", "Antonina", "Generic", "The seventh", "2002-02-16", 
"2019-09-01", 53, "tonyageneric1602@gmail.com", "IR-21", "L'viv", "Zagal'noosvitnya shkola №84");
CALL insert_into_student("A00000002I", "Kateryna", "Generic", "The eighth", "2001-01-15", 
"2019-09-01", 88, "katyageneric1501@gmail.com", "IR-21", "L'viv", "Obscheobrazovatel'naya shkola №34");
CALL insert_into_student("A00000023J", "Anzhela", "Generic", "The ninth", "2003-09-23", 
"2021-09-01", 55, "anzhelageneric2309@gmail.com", "IR-21", "L'viv", "Zagal'noosvitnya shkola №84");

INSERT INTO student_has_academic_failure(student_id, failure_subject)
VALUES ("A00000001A", "Algoritmization and programming"), ("A00000001A","Web programming and design"), 
("A00000001A","Organisation of data bases and structures"), ("A00000023J","Algoritmization and programming"), 
("A00000123C","Web programming and design"), ("A12345678H","Organisation of data bases and structures"), 
("A00000023J","High math"), ("A00000123C","Algoritmization and programming"), 
("A12345678H","Web programming and design"), ("A00000012B","High math");
--CREATE TABLE app.professional (
--  prof_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
--  profname VARCHAR(100),
--  profemail VARCHAR(100)
-- );
  
--INSERT INTO app.professional(profname, profemail) VALUES('Fred Jones','test1@yahoo.com');
--INSERT INTO app.professional(profname, profemail) VALUES('Rita Jones','test2@yahoo.com');
--INSERT INTO app.professional(profname, profemail) VALUES('Bata Jones','test3@yahoo.com');
--INSERT INTO professional(profname, profemail) VALUES('Bhu Kumar','test5@yahoo.com');

select * from PROFESSIONAL

select * from category
select * from subcategory
select * from expenses
-- drop table expenses;

SELECT count(*) as count FROM Professional

SELECT c.category_name,s.subcategory_name from CATEGORY c
INNER JOIN subcategory s on c.category_id = s.category_id 

CREATE TABLE category (
  category_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
  category_name VARCHAR(100)
   );

CREATE TABLE subcategory (
  subcategory_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
  subcategory_name VARCHAR(100),
  category_id INTEGER
   );

CREATE TABLE Expenses (
  expense_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  expense_date DATE, 
  category_id INTEGER ,
  category_name VARCHAR(100),
  subcategory_id INTEGER ,
  subcategory_name VARCHAR(100),
  amount INTEGER
   );

INSERT INTO category(category_name) VALUES('automobile');
INSERT INTO category(category_name) VALUES('entertainment');
INSERT INTO category(category_name) VALUES('food');
INSERT INTO category(category_name) VALUES('healthcare');
INSERT INTO category(category_name) VALUES('household');
INSERT INTO category(category_name) VALUES('loans');
INSERT INTO category(category_name) VALUES('bills');
INSERT INTO category(category_name) VALUES('shopping');
   

INSERT INTO subcategory(subcategory_name,category_id) VALUES('fuel',1);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('insurance',1);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('maintenance',1);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('movies',2);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('party',2);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('gifts',2);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('kidsplay',2);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('restuarant',3);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('snacks',3);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('homefood',3);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('sanmedicals',4);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('bhumedicals',4);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('healthinsurance',4);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('shikamedicals',4);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('nandhanmedicals',4);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('home',5);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('bhu',5);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('vehicleloan',6);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('cc loan',6);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('internet',7);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('mobiles',7);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('school',7);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('cook',7);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('sanshopping',6);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('bhushopping',6);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('kidsshopping',6);
INSERT INTO subcategory(subcategory_name,category_id) VALUES('kidsessentials',6);


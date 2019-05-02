create database if not exists bookAplication;

use bookAplication;

drop table if exists books;

create table books (
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
   bookName varchar(255),
   bookAuthor varchar(255),
   bookPublisher varchar(255),
   publication_date varchar(255),
   primary key (id),
   unique (id)
);

insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('English','Vocabulary', 'PrintUK', '2010');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Thriller','St.King','California Inc', '2005');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Avengers V','MARVEL','21st FOX','2019');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Bird','NatGeo','AmericanPress', '2007');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Fantasy','St.King','California Inc', '2010');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Danish','Vocabulary','PrintUK','2012');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Dog','NatGeo','AmericanPress', '2007');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Drama','St.King','California Inc', '2007');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Guardians GALAXY 2','MARVEL','21st FOX','2018');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Cow','NatGeo','AmericanPress', '2009');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Avengers','MARVEL','21st FOX','2015');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Spanish','Vocabulary','PrintUK', '2011');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Horse','NatGeo','AmericanPress', '2008');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Adventure','St.King','Shobizz', '2009');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Deutsch','Vocabulary', 'PrintUK', '2010');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Science','St.King','Shobizz', '2010');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Cpt Marvel','MARVEL','21st FOX','2019');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Guardians GALAXY','MARVEL','21st FOX','2016');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('French','Vocabulary', 'PrintUK', '2010');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Cat','NatGeo','AmericanPress', '2007');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Shazamm','MARVEL','21st FOX','2017');
insert into books(bookName, bookAuthor, bookPublisher, publication_date) values ('Russian','Vocabulary', 'PrintUK', '2010');


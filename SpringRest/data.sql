create database if not exists bookAplication;

use bookAplication;

drop table if exists BOOKSHELF;

create table BOOKSHELF (
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
   BOOKNAME varchar(255),
   BOOKAUTHOR varchar(255),
   BOOKPUB varchar(255),
   PUBDATE varchar(255),
   primary key (id),
   unique (id)
);

TRUNCATE TABLE BOOKSHELF;

ALTER TABLE BOOKSHELF AUTO_INCREMENT=1001;

insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('English','Vocabulary', 'PrintUK', '2010');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Thriller','St.King','California Inc', '2005');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Avengers V','MARVEL','21st FOX','2019');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Bird','NatGeo','AmericanPress', '2007');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Fantasy','St.King','California Inc', '2010');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Danish','Vocabulary','PrintUK','2012');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Dog','NatGeo','AmericanPress', '2007');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Drama','St.King','California Inc', '2007');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Guardians GALAXY 2','MARVEL','21st FOX','2018');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Cow','NatGeo','AmericanPress', '2009');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Avengers','MARVEL','21st FOX','2015');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Spanish','Vocabulary','PrintUK', '2011');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Horse','NatGeo','AmericanPress', '2008');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Adventure','St.King','Shobizz', '2009');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Deutsch','Vocabulary', 'PrintUK', '2010');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Science','St.King','Shobizz', '2010');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Cpt Marvel','MARVEL','21st FOX','2019');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Guardians GALAXY','MARVEL','21st FOX','2016');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('French','Vocabulary', 'PrintUK', '2010');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Cat','NatGeo','AmericanPress', '2007');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Shazamm','MARVEL','21st FOX','2017');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('Russian','Vocabulary', 'PrintUK', '2010');
insert into BOOKSHELF(BOOKNAME, BOOKAUTHOR, BOOKPUB, PUBDATE) values ('testName','testAuthor', 'testPublisher', 'testDate');


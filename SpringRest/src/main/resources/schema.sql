create table BOOKSHELF (
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
   BOOKAUTHOR varchar(255),
   BOOKPUB varchar(255),
   PUBDATE varchar(255),
   BOOKNAME varchar(255),
   BOOKPOST varchar(255),
   primary key (id),
   unique (id)
);

--ALTER TABLE BOOKSHELF AUTO_INCREMENT=1001;
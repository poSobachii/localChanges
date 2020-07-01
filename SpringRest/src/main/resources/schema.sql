create table BOOKSHELF (
   BOOKPUB varchar(255),
    BOOKAUTHOR varchar(255),
    PUBDATE varchar(255),
   BOOKNAME varchar(255),
   BOOKPOST varchar(255),
   id MEDIUMINT NOT NULL AUTO_INCREMENT,
   primary key (id),
   unique (id)
);

--ALTER TABLE BOOKSHELF AUTO_INCREMENT=1001;
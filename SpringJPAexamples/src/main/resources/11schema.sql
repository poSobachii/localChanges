create table myUSER (
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
   USERNAME varchar(255),
   USERSURNAME varchar(255),
   USERAGE int,
   USERADRESS varchar(255),
   EMAILADRESS varchar(255),
   primary key (id),
   unique (id)
);

create table userINFO(
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
   CITY varchar(255),
   COUNTRY varchar(255),
   STREET varchar(255),
   POSTALCODE int,
   primary key (id),
   unique (id)
);

create table emailTable(
   id MEDIUMINT NOT NULL AUTO_INCREMENT,
   email varchar(255),
   domainx varchar(30),
   host varchar(255),
   primary key (id)
   );
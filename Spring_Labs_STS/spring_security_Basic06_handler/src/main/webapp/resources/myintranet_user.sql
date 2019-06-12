CREATE TABLE `user` (
  `EMAIL` varchar(255) NOT NULL,
  `PASSWD` varchar(255) NOT NULL,
  `ENABLED` int(1) NOT NULL DEFAULT '1',
  `AUTHORITY` varchar(20) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



create table userT(
 email varchar2(200) primary key,
 passwd varchar2(200) not null,
 enabled number default 1 not null,
 authority varchar2(20) default 'ROLE_USER' not null
);
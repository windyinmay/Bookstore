create table book (
	id int primary key auto_increment, 
	title varchar(200), 
	year int, 
	author varchar(100), 
	isbn varchar(20), 
	price float
);

insert into book (
	id,
	author, 
	isbn, 
	price, 
	title, 
	year
) values (
	1,
	'Earnest Hemingway', 
	'ABCXYZ', 
	200, 
	'A Farewell to Arms', 
	1929
);

insert into book (
	id,
	author, 
	isbn, 
	price, 
	title, 
	year
) values (
	2,
	'Pham Duy', 
	'GIEOHUONG', 
	200, 
	'TINH CA', 
	1953
);
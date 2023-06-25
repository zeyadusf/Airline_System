 CREATE DATABASE airline;
USE airline;

CREATE TABLE flights (
	fl_id varchar(7) primary key ,
    fl_takeoff VARCHAR(20) not null,
    fl_landing VARCHAR(20) not null,
    fl_date VARCHAR(12) not null ,
    fl_seats int not null
);

 CREATE TABLE passengers (
 	passport_id int primary key,
 	pass_fname varchar(25) not null,
     pass_lname varchar(25) not null,
     pass_gender varchar(6) not null,
 	pass_phone varchar(11) ,
     pass_nationality varchar(20)
 );
CREATE TABLE tickets (
	passport_id int references passengers(passport_id),
    pass_fname varchar(25) references passengers (pass_fname),
    pass_lname varchar(25) references passengers (pass_lname),
    pass_gender varchar(6) references passengers (pass_gender),
    pass_nationality varchar(20) references passengerspass_nationality (pass_nationality),
    fl_id varchar(7) references flights (fl_id),
    fl_date VARCHAR(12) references flights (fl_date),
	fl_takeoff VARCHAR(20) references flights( fl_takeoff ),
    fl_landing VARCHAR(20) references flights( fl_landing )
);



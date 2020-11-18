#---create datebase:
create database mg_hotel;
use mg_hotel;

#--- creating tables:

create table guest(
cin varchar(8) primary key,
f_name varchar(20) not null,
last_name varchar(20) not null,
email varchar(30) default "<emty>",
gsm varchar(8) not null,
comments text ,
p_card_nmb varchar(16),
p_card_own varchar(40)
);

create table room(
id_room varchar(4) primary key,
type_r varchar(15) not null,
beds varchar(10) not null,
view varchar(15) not null,
cost double not null,
add_cost double ,
order_id varchar(11),
reserved boolean default false 
);

create table staff(
id_emp int(8) primary key,
pass_code varchar(8),
f_name varchar(20) not null,
l_name varchar(20) not null,
age int not null,
gsm varchar(8) not null,
salary double not null,
job varchar(15) not null
);

create table reservation(
id_rev int(11)  primary key  auto_increment,
id_room varchar(8) references room(id_room),
cin_guest varchar(8) references guest(cin),
id_emp int(8) references staff(id_emp),
d_begin date not null,
d_end date not null,
g_check_in datetime ,
g_check_out datetime 
);

create table ordertype(
ord_type varchar(20) primary key,
cost double not null,
serve_time time not null
);

create table orders(
order_id int(11) primary key auto_increment,
order_type text ,
room_id varchar(4) references room(id_room),
date_ord datetime not null,
t_cost double
);











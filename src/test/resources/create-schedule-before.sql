delete from schedule_record;
delete from student;
delete from `day`;
delete from pair;
delete from schedule;
delete from group_;
delete from subject;


insert into group_(id_group,caption,email) values
(10 ,"EXAMPLE1","example1@gmail.com"),
(11,"EXAMPLE2","example2@gmail.com" );
insert into student(id_student,first_name,patronymic,second_name,group_id_group) values
(10 ,"Иван","Иванович","Иванов",10),
(11,"Петр","Петрович","Петров",11 );
insert into `day`(id_day,caption,short_caption) values
(10,"Понедельник","Пн"),
(11,"Вторник","Вт"),
(12,"Среда","Ср");
insert into pair(id_pair,start_time,end_time,`number`) values
(10,'09:00:00','10:30:00',1),
(11,'10:40:00','12:10:00',2),
(12,'12:40:00','14:10:00',3);
insert into schedule(id_schedule,group_id_group) values
(10,10),
(11,11);
insert into subject(id_subject,caption) values
(10,'first'),
(11,'second'),
(12,'third');
insert into schedule_record(id_schedule_record,days_id_day,pairs_id_pair,schedule_id_schedule,subject_even_id_subject,subject_odd_id_subject) values
(10,10,10,10,10,10),
(11,10,10,10,10,11),
(12,10,10,10,12,11);
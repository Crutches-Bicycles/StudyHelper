delete from account;
delete from student;
delete from group_;


insert into group_(id_group,caption,email) values
(10 ,"EXAMPLE1","example1@gmail.com"),
(11,"EXAMPLE2","example2@gmail.com" );
insert into student(id_student,first_name,patronymic,second_name,group_id_group) values
(10 ,"Иван","Иванович","Иванов",10),
(11,"Петр","Петрович","Петров",11 );
insert into account(id_account,student_id_student,email,password,account_type) values
(10 ,10,"example@gmail.com","$2a$10$h23aJdpXloE1MzAVcC/.1O9BYULH6RUgV.vcSwnmdQ36DQzV05h8q","ADMIN"),
(11, 11,"example1@gmail.com","$2a$10$TTsCpXJLflkWnmKPoFeo5eI3cZ41yJjr8/l2h6bhoM42OmHu/RrCy","USER"),
(12, null,"example2@gmail.com","$2a$10$TTsCpXJLflkWnmKPoFeo5eI3cZ41yJjr8/l2h6bhoM42OmHu/RrCy","USER");





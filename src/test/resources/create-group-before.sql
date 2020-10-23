delete from group_teacher_teachers;
delete from group_teacher;
delete from group_;
delete from teacher;


insert into group_(id_group,caption,email) values
(10 ,"EXAMPLE1","example1@gmail.com"),
(11,"EXAMPLE2","example2@gmail.com" );
insert into group_teacher(id_group_teacher,group_id_group) values
(10,10);
insert into teacher(id_teacher,email,first_name,second_name,patronymic) values
(10,"example1@gmail.com","Иван","Иванов","Иванович"),
(11,"example2@gmail.com","Андрей","Андреев","Андреевич");
insert into group_teacher_teachers(group_teacher_id_group_teacher,teachers_id_teacher) values
(10,10),
(10,11);

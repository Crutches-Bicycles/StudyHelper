delete from teacher_subject_subjects;
delete from group_teacher_teachers;
delete from group_teacher;
delete from teacher_subject;
delete from group_;
delete from teacher;
delete from subject;

insert into subject(id_subject,caption) values
(10,'first'),
(11,'second'),
(12,'third'),
(13,'fourth');
insert into group_(id_group,caption,email) values
(10 ,"EXAMPLE1","example1@gmail.com"),
(11,"EXAMPLE2","example2@gmail.com" ),
(12,"EXAMPLE3","example3@gmail.com" );
insert into group_teacher(id_group_teacher,group_id_group) values
(10,10),
(11,11);
insert into teacher(id_teacher,email,first_name,second_name,patronymic) values
(10,"example1@gmail.com","Иван","Иванов","Иванович"),
(11,"example2@gmail.com","Андрей","Андреев","Андреевич");
insert into group_teacher_teachers(group_teacher_id_group_teacher,teachers_id_teacher) values
(10,10),
(10,11),
(11,10);
insert into teacher_subject(id_teacher_subject,teacher_id_teacher) values
(10,10);
insert into teacher_subject_subjects(teacher_subject_id_teacher_subject,subjects_id_subject) values
(10,10),
(10,11),
(10,12);


delete from student_material_subject;
delete from student_material;
delete from subject;
delete from student;
delete from group_;

insert into group_(id_group,caption,email) values
(10 ,"EXAMPLE1","example1@gmail.com"),
(11,"EXAMPLE2","example2@gmail.com" );
insert into student(id_student,first_name,patronymic,second_name,group_id_group) values
(10 ,"Иван","Иванович","Иванов",10),
(11,"Петр","Петрович","Петров",11 );
insert into subject(id_subject,caption) values
(10,'first'),
(11,'second'),
(12,'third');
insert into student_material(id_material,caption,description,file,link_to,student_id_student) values
(10,"example1","exampleDesc1","exampleFile1","exampleLink1",10),
(11,"example2","exampleDesc2","exampleFile2","exampleLink2",11),
(12,"example3","exampleDesc3","exampleFile3","exampleLink3",10);

insert into student_material_subject(student_material_id_material,subject_id_subject) values
(10,10),
(12,12),
(11,11);
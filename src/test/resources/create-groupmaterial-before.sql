delete from group_material_subject;
delete from group_material;
delete from group_;
delete from subject;


insert into group_(id_group,caption,email) values
(10 ,"EXAMPLE1","example1@gmail.com"),
(11,"EXAMPLE2","example2@gmail.com" );
insert into group_material(id_material,caption,description,file,link_to,group_id_group) values
(10,"example1","exampleDesc1","exampleFile1","exampleLink1",10),
(11,"example2","exampleDesc2","exampleFile2","exampleLink2",11),
(12,"example3","exampleDesc3","exampleFile3","exampleLink3",10);
insert into subject(id_subject,caption) values
(10,'first'),
(11,'second'),
(12,'third');
insert into group_material_subject(group_material_id_material,subject_id_subject) values
(10,10),
(11,11),
(12,12);



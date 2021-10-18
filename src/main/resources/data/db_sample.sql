insert into student (created_date, house_type, name, pet_type) values (date(current_date), 1, 'Tiffany Ray', 0);
insert into student (created_date, house_type, name, pet_type) values (date(current_date), 2, 'Lena Keller', 1);
insert into student (created_date, house_type, name, pet_type) values (date(current_date), 3, 'Michael Oxlong', 0);
insert into student (created_date, house_type, name, pet_type) values (date(current_date), 1, 'Evie Wood', 3);
insert into student (created_date, house_type, name, pet_type) values (date(current_date), 0, 'Rex Middleton', 2);
insert into student (created_date, house_type, name, pet_type) values (date(current_date), 2, 'Lawrence Nunez', 0);

insert into room (needs_renovation) values (true);
insert into room (needs_renovation, student_id) values (false, 1);
insert into room (needs_renovation) values (false);
insert into room (needs_renovation, student_id) values (false, 2);
insert into room (needs_renovation, student_id) values (false, 3);
insert into room (needs_renovation, student_id) values (true, 4);
insert into room (needs_renovation) values (false);
insert into room (needs_renovation, student_id) values (false, 5);
insert into room (needs_renovation) values (false);
insert into room (needs_renovation, student_id) values (true, 6);
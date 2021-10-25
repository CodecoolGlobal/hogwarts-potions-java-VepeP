insert into room (needs_renovation, capacity) values (true, 2);
insert into room (needs_renovation, capacity) values (false, 1);
insert into room (needs_renovation, capacity) values (false, 2);
insert into room (needs_renovation, capacity) values (false, 2);
insert into room (needs_renovation, capacity) values (false, 3);
insert into room (needs_renovation, capacity) values (true, 4);
insert into room (needs_renovation, capacity) values (false, 3);
insert into room (needs_renovation, capacity) values (false, 5);
insert into room (needs_renovation, capacity) values (false, 1);
insert into room (needs_renovation, capacity) values (true, 6);

insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 0, 'Harry Potter', 0, 1);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 0, 'Ronald Weasley', 1, 1);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 0, 'Neville Longbottom', 0, 2);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 1, 'Ernie Macmillan', 3, 3);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 1, 'Justin Finch-Fletchley', 2, 4);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 1, 'Hannah Abbott', 0, 5);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 2, 'Terry Boot', 3, 7);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 2, 'Mandy Brocklehurst', 2, 7);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 2, 'Michael Corner', 0, 8);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 3, 'Vincent Crabbe', 3, 8);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 3, 'Vincent Crabbe', 2, 10);
insert into student (created_date, house_type, name, pet_type, room_id) values (date(current_date), 3, 'Blaise Zabini', 0, 10);

insert into ingredient (name) values ('ashwinder egg');
insert into ingredient (name) values ('rose thorn');
insert into ingredient (name) values ('peppermint');
insert into ingredient (name) values ('powered moonstone');
insert into ingredient (name) values ('pearl dust');
insert into ingredient (name) values ('red wine');
insert into ingredient (name) values ('prune juice');
insert into ingredient (name) values ('hairy fungus');
insert into ingredient (name) values ('tortoise shell');
insert into ingredient (name) values ('caterpillar');
insert into ingredient (name) values ('bat tongue');

insert into recipe (name, student_id) values ('Harry Potter''s Discovery', 1);

insert into potion (brewing_status, name, recipe_id, student_id) values (2, 'Amortentia', 1, 1);

insert into potion_ingredients (potions_id, ingredients_id) values (1, 1);
insert into potion_ingredients (potions_id, ingredients_id) values (1, 2);
insert into potion_ingredients (potions_id, ingredients_id) values (1, 3);
insert into potion_ingredients (potions_id, ingredients_id) values (1, 4);
insert into potion_ingredients (potions_id, ingredients_id) values (1, 5);

insert into recipe_ingredients (recipes_id, ingredients_id) values (1, 1);
insert into recipe_ingredients (recipes_id, ingredients_id) values (1, 2);
insert into recipe_ingredients (recipes_id, ingredients_id) values (1, 3);
insert into recipe_ingredients (recipes_id, ingredients_id) values (1, 4);
insert into recipe_ingredients (recipes_id, ingredients_id) values (1, 5);

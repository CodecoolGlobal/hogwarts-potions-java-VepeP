# Hogwarts Houses - sprint 1

## Story

What if I said, that magic is real? What if I said, that wizards, witches, and all the Harry Potter world is real, and they need you now?

In this rushing, modern world, they can't just solve everything with spells and potions! That's why now more than ever,
Hogwarts School of Witchcraft and Wizardry needs a little bit of Muggle technology, so that house management of this
enourmous castle isn't so problematic. Of course, since witches and wizards have no idea about technology, you'll
disguise your API as a set of more wizard-friendly spells, so that it's more intuitive for the target audience.

Let the techno... ahem, magic, begin!

## What are you going to learn?

You will learn and practice how to do the following things:

- Building Web API in Spring
- MVC design pattern
- Building DAOs
- Thymeleaf basics


## Tasks

1. Dumbledore tasked prof. McGonagall with writing down a list of all rooms on a piece of parchment. The deadline is tomorrow, so she will need your help!
    - A list of all rooms is returned upon calling the `/rooms` endpoint with GET method.
    - An HTML template for displaying all listed rooms is created.

2. By some magical accident, Hogwarts is completely out of rooms! We need to create some new empty rooms, so that the students have a place to live in.
    - A new room can be added upon calling the `/rooms` endpoint with POST method.

3. "Keep an eye on the staircases. They like to change." It turned out to be true, which makes really easy to get lost. Poor Luna just got lost in the building and the only thing she remembers is the room's number.. Help Luna to find her room by that number!
    - A room with given ID is returned upon calling the `/rooms/{roomId}` endpoint with GET method.

4. While playing around with the Locus Novus spell, a few misplaced rooms have popped out accidentally and now they block some corridors. We need a reverse spell, that unmakes a room.
    - A room with given ID is deleted upon calling the `/rooms/{roomID}` endpoint with DELETE method.

5. Some rooms require a bit of renovating, as they have become old, messy and ulgy over the hundreds of years of usage.
    - A room with given ID is updated upon calling the `/rooms/{roomId}` endpoint with PUT method.

6. Hermione Granger and Draco Malfoy have just arrived to Hogwarts. As long as they are not on the list of the students, Filch will not allow them to enter. Put them on the list, so they can enter before the dinner is over.
    - Two student entities are stored in the application's memory.

7. Dinner's over, time to bed! But wait, which one? Hermione and Draco aren't assigned to their new rooms yet! Help them find their new rooms (separate, of course).
    - At least two empty rooms are stored in the application's memory.
    - Hermione and Draco are assigned to separate rooms.

8. Halloween is coming and Hogwarts need a new, nicer look. Help the teachers with the decoration!
    - Create a stylesheet and change the look of the website!

9. Poor Neville! He lost his frog on the train and arrived quite late to the school. Are there any empty rooms left? Help Neville to find all the available rooms, so that he has a place to stay!
    - A list of all available rooms is returned upon calling the `/rooms/available` endpoint with GET method.

10. Hermione and Ron just had an argument about their pets. Crookshanks tried to catch and eat Scabbers (again!). Concerned about safety of his rat, Ron can only stay in a room, in which nobody has a cat or an owl. Help Ron find a safe room for his pet!
    - A list of rooms, which residents do not have cats or owls, is returned upon calling the `/rooms/rat-owners` endpoint with GET method.

## General requirements

None

## Hints



## Background materials

 - [About Spring](project/curriculum/materials/competencies/java-spring-basics/about-spring.md.html)
 - [Spring Configuration](project/curriculum/materials/competencies/java-spring-basics/spring-configuration.md.html)
 - [Spring IOC](project/curriculum/materials/competencies/java-spring-basics/spring-ioc.md.html)
 - [Spring RestFul API](project/curriculum/materials/competencies/java-spring-basics/spring-restful-api.md.html)



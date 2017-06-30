Ethan Tuning
5/23/2017
CSCD349
Assignment 7 Readme

1. Created a Dungeon Character factory so I could create characters
   without any worry about the underlying object.

2. Abstracted attack and defend from Dungeon Character hierarchy. Just for decoupling.

3. Created a Battle class, just so its easier to create a new battle.

4. Made the different Attacks into thier own class. So if adding new characters, it is
   easy to have any type of attack be implemented.

5. Created new driver for program so that it will be easier to implement save-game, GUI, etc features.

6. Took away the battle choices that were in the characer classes and re-wrote that as one method
   in the battle class. This is duplicate code and did not really belong in there.
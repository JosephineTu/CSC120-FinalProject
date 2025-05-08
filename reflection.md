What was your overall approach to tackling this project?
Determine the important factors that control the flow of the game-the Health, Money, Person etc. classes. We first settled on the associations between these classes, and made them as attributes of the RunGame class(the part that pushes the game forward). In this way, the player can actively modify the factors that determine their game development, as well as easily protecting other static parts. 

What new thing(s) did you learn / figure out in completing this project?
We learned about faster and more precise ways to tackle user inputs- such as storing sentence particles in HashMaps, and using the switch method to quickly go over existing options. We also became better at passing around objects. For example, the Player p object is an argument in many methods in RunGame. Instead of importing all of Player class' information, we can easily access attributes and methods we want by passing it as an parameter.

Is there anything that you wish you had implemented differently?
We could have make the game more resembles an open-world game in which the player can freely decide where to start from and where to go next. For example, they do not necessarily need to start school at 6, and they would have more options to interact with NPCs, instead of having NPCs act as events that is thrown by the code. 

If you had unlimited time, what additional features would you implement?
We would include graphics that dynamically shows the percentage of health, intelligence and relationships. We would definitely include more variations in environment-triggered events. 

What was the most helpful piece of feedback you received while working on your project? Who gave it to you?
The most helpful piece of feedback is how can we implement the verbs as prompt because there are a lot of actions the user could do. This advice help us decide what should we have on our cheatsheet. This advice is from Savannah Ko and Harlow. They ask me the same question after hearing our project.

If you could go back in time and give your past self some advice about this project, what hints would you give?
Before filling out all the methods in a specific class, could start on RunGame earlier, this gave a sense of what are the core variables/objects that have a big influence on many events in the game. This also gives suggestions on creating more effective data structures to store objects such as Person and Job. 

If you worked with a team: please comment on how your team dynamics influenced your experience working on this project.
Josephine-RunGame, Health, debugging and resolving functional issues.
Gemma-Partner, Person, architecture diagram modification, javadoc comments
Sierra-Intelligence, Money, cheatsheet, architecture diagram modification

Design justification (including a brief discussion of at least one alternative you considered)
Our current approach was consistent from the very start, but we do have considered making degrees/disease as String objects, but we found out that enum might be a more effective way to accurately locate the exact name and ordinal. 
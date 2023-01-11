In <b>Project 4</b>, I used Stacks and Queues to solve basic mazes. A maze is a network of paths designed so there is at least one path from the entrance of the maze to the exit of the maze. I used a queue structure to find this correct path through the maze, and a stack structure to randomly generate new mazes.

<b>Classes Written By Me:</b>
<ui><li>MyMaze.java</li></ui>

<b>Classes Given From Class:</b>
<ui><li>Cell.java</li>
<li>NGen.java</li>
<li>Q1Gen.java</li>
<li>QGen.java</li>
<li>Stack1Gen.java</li>
<li>StackGen.java</li></ui>

<b>MyMaze.java</b>

There are three main methods in this class: makeMaze, printMaze, and solveMaze. makeMaze will instantiate a new MyMazaze object, generate the maze, and then return the new MyMaze object. printMaze will print a visual respresentation of the maze in the terminal. Vertical bars | represent vertical borades, and dashes --- represent horizontal borders. solveMaze will use a queue in order to find the path to solve the maze. Asterisks "*" show where the method visted to solve the maze. 

<b>All Other Classes:</b>

All the other classes were given to assist in MyMaze.java. They help create the default structure/class of stacks and queues. Cell.java contains the attributes of each cell in the maze. 
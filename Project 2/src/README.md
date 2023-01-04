<b>Project 2</b> involes devloping a simplified version of chess. 2D arrays represent the chess board. Pawn promotion is implemented. The normal chess piece rules apply. 

<b>Classes written by me:</b>
<ul> <li> Game.java </li>
<li> Rook.java </li>
<li> Bishop.java </li>
<li> Knight.java </li> 
<li> Queen.java </li>
<li> King.java </li>
<li> Board.java </li></ul>

<b>Classes edited from class:</b>
<ul> <li> Piece.java </li> </ul>

<b>Classes given from class:</b>
<ul> <li> Pawn.java </li> 
 <li> Fen.java </li> </ul>

<b>Board.java: </b>

This class serves as the representation of a chess board. It is represented as a 2-Dimensional Array of type Piece. The class will also verify if the move desired by the user is legal or not, updating the piece and position of the borad. It is also determine when the game has ended. 

<b>Piece.java:</b>

An object
of type Piece contains an instance variable which is initialized to a Unicode character for one of
the 6 chess pieces. Using this char variable, Piece’s isMoveLegal() will redirect query to the
proper method for rule-checking.

<b>Game.java:</b>

Game.java is the class which contains this project’s main method. Within this main method we
must create an interactive terminal experience for the players to interact with throughout the game.
This class will instantiate the Board object and prompt the user for input. A visual representation
of the board will be printed at the beginning of each player’s turn. The user should enter a starting
point and an ending point, but all other work to execute the turn will happen elsewhere. The
game will end when one player’s King has been “captured”.

<b>Fen.java:</b>

This class was provided by the class. It is based on Forsyth-Edwards Notation which is a method
for saving the position of every piece on a chess board in 71 characters or less.

<b>Chess Pieces (Rook, Bishop, Knight, Queen, King, Pawn): </b>

Each different type of chess piece will determine whether the move the player desire is legal or not.
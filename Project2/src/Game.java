import java.util.Scanner;
public class Game {
    public static void main(String[] args){
        Fen myFen = new Fen();
        Board myBoard = new Board();
        //instantiate the board and the fen necessary to print out starting positions
        myFen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", myBoard);
        System.out.println(myBoard);
        while (!myBoard.isGameOver()){
            //Keeps looping until one of the kings is captured to signify who won
            Scanner myScanner = new Scanner(System.in);
            while (true) {
                //keeps looping until white enters a valid move
                System.out.println("It is currently white's turn to play.");
                System.out.println("What is your move?");
                String input = myScanner.nextLine();
                int startRow = Integer.parseInt(input.substring(0, 1));
                int startCol = Integer.parseInt(input.substring(2, 3));
                int endRow = Integer.parseInt(input.substring(4, 5));
                int endCol = Integer.parseInt(input.substring(6, 7));
                //converts the input the user enters into individual integers to be used to call various methods
                Boolean temp = false;
                if (myBoard.verifySourceAndDestination(startRow, startCol, endRow, endCol, false)) {
                    //checks if user entered a valid move
                    //if true, moves the piece from the start position to the end position
                    //checks if pawn promotion is needed
                      temp = myBoard.movePiece(startRow, startCol, endRow, endCol);
                      myBoard.getPiece(endRow, endCol).pawnPromotion();
                    if (temp){
                        //breaks the loop if user entered a valid move
                        break;
                    }
                }
                if (!temp){
                    //when user enters invalid move, prompted to reenter
                    System.out.println("That was not valid. Please enter another move.");
                }
                if (myBoard.isGameOver()) {
                    //checks if both kings still are on the board to continue the game
                    break;
                }
            }
            if (myBoard.isGameOver()) {
                //checks if both kings still exist
                //if not, game is over and white wins
                System.out.println(myBoard);
                System.out.println("Game OVER!!!!!!! White WONNNNN!!!!!");
                break;
            }
            System.out.println(myBoard);
            while (true) {
                //keeps looping until black enters a valid move
                System.out.println("It is currently black's turn to play.");
                System.out.println("What is your move?");
                String binput = myScanner.nextLine();
                int bstartRow = Integer.parseInt(binput.substring(0, 1));
                int bstartCol = Integer.parseInt(binput.substring(2, 3));
                int bendRow = Integer.parseInt(binput.substring(4, 5));
                int bendCol = Integer.parseInt(binput.substring(6, 7));
                //converts the input the user enters into individual integers to be used to call various methods
                Boolean temp = false;
                if (myBoard.verifySourceAndDestination(bstartRow, bstartCol, bendRow, bendCol, true)) {
                    //checks if user entered a valid move
                    //if true, moves the piece from the start position to the end position
                    //checks if pawn promotion is needed
                    temp = myBoard.movePiece(bstartRow, bstartCol, bendRow, bendCol);
                    myBoard.getPiece(bendRow, bendCol).pawnPromotion();
                    if (temp){
                        //breaks the loop if user entered a valid move
                        break;
                    }
                }
                if (!temp){
                    //when user enters invalid move, prompted to reenter
                    System.out.println("That was not valid. Please enter another move.");
                }
                if (myBoard.isGameOver()) {
                    //checks if both kings still are on the board to continue the game
                    break;
                }
            }
            if (myBoard.isGameOver()) {
                //checks if both kings still exist
                //if not, game is over and black wins
                System.out.println(myBoard);
                System.out.println("Game OVER!!!!!!! Black WONNNNN!!!!!");
                break;
            }
            System.out.println(myBoard);
        }
    }
}

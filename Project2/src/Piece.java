//Written by Elaine Cui, CUI00122 and Adam Liu, LIU02390
import java.util.Scanner;
public class Piece {

    // Instance variables
    private char character;
    private int row;
    private int col;
    private boolean isBlack;

    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
       switch (this.character) {
            // Pawn chars
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            // Rook chars
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            // Knight chars
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            // Bishop chars
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            // Queen chars
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            // King chars
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the current chess unicode character.
     * @return Unicode character.
     */
    public char getCharacter(){
        return this.character;
    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {
        return this.isBlack;
    }

    /**
     * Tests the equality of two Piece objects based on
     * their character parameter.
     * @param other An instance of Piece to compare with this
     *              instance.
     * @return Boolean value representing equality result.
     */
    public boolean equals(Piece other){
        return this.character == other.character;
    }

    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return "" + this.character;
    }

    //checks if the pawn is at the end of its row and lets the user choose what piece it want to convert to
    public boolean pawnPromotion() {
        Scanner myScanner = new Scanner(System.in);
        if (this.character == '\u2659' || this.character == '\u265f'){
            if (this.row == 0 || this.row == 7) {
                //checks whether the piece at the end of the rows are pawns
                System.out.println("Please enter what piece you would like in place of the pawn: (Rook, Knight, Bishop, or Queen)");
                String input = myScanner.nextLine();
                if (!this.isBlack) {
                    //determines what color the user is using pawn promotion
                    switch (input) {
                        //assigns the users choice ot the pawn
                        case "Rook":
                            this.character = '\u2656';
                            return true;
                        case "Knight":
                            this.character = '\u2658';
                            return true;
                        case "Bishop":
                            this.character = '\u2657';
                            return true;
                        case "Queen":
                            this.character = '\u2655';
                            return true;
                    }
                }
                if (this.isBlack) {
                    switch (input) {
                        //assigns the users choice ot the pawn
                        case "Rook":
                            this.character = '\u265c';
                            return true;
                        case "Knight":
                            this.character = '\u265e';
                            return true;
                        case "Bishop":
                            this.character = '\u265d';
                            return true;
                        case "Queen":
                            this.character = '\u265b';
                            return true;
                    }
                }
            }
        }
        return false;
        //returns false if the pawn isn't at the end of its row or the piece isn't a pawn
    }
}


//Written by Elaine Cui, CUI00122 and Adam Liu, LIU02390
public class Knight {
    private int row;
    private int col;
    private boolean isBlack;

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    } //constructor for Knight object

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        //check if there is a piece at the entered coordinate
        if (board.getPiece(endRow, endCol) == null) {
            //determine if Knight is moving a legal number of squares
            return ((endRow == this.row + 1) && (endCol == this.col + 2)) ||
                    ((endRow == this.row + 2) && (endCol == this.col + 1) ||
                            ((endRow == this.row - 1) && (endCol == this.col - 2)) ||
                            ((endRow == this.row - 2) && (endCol == this.col - 1)) ||
                            ((endRow == this.row + 1) && (endCol == this.col - 2)) ||
                            ((endRow == this.row + 2) && (endCol == this.col - 1) ||
                                    ((endRow == this.row - 1) && (endCol == this.col + 2)) ||
                                    ((endRow == this.row - 2) && (endCol == this.col + 1))));
        }
        if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) {
            // There is a piece of the opposite color to be captured.
            return ((endRow == this.row + 1) && (endCol == this.col + 2)) ||
                    ((endRow == this.row + 2) && (endCol == this.col + 1) ||
                    ((endRow == this.row - 1) && (endCol == this.col - 2)) ||
                    ((endRow == this.row - 2) && (endCol == this.col - 1)) ||
                    ((endRow == this.row + 1) && (endCol == this.col - 2)) ||
                    ((endRow == this.row + 2) && (endCol == this.col - 1) ||
                    ((endRow == this.row - 1) && (endCol == this.col + 2)) ||
                    ((endRow == this.row - 2) && (endCol == this.col + 1))));
        } else {
            return false;
        } //return false if move is illegal
    }
}
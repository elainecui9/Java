//Written by Elaine Cui, CUI00122 and Adam Liu, LIU02390
public class Queen {
    private int row;
    private int col;
    private boolean isBlack;
    public Queen(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    } //constructor for Queen object
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        //determine if direction of movement is legal
        if (board.verifyVertical(this.row, this.col, endRow, endCol) || board.verifyHorizontal(this.row, this.col, endRow, endCol) || board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
            //determine if coordinate is empty, allowing the piece to move there
            if (board.getPiece(endRow, endCol) == null) {
                return true;
            }
            if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) {
                // There is a piece of the opposite color to be captured.
                return true;
            } else {
                return false;
            }
        }
        return false;
    } //returns false if move is illegal
}
//Written by Elaine Cui, CUI00122 and Adam Liu, LIU02390
public class Board {
    private Piece[][] board;


    public Board() {
        //initializes board
        board = new Piece[8][8];
    }

    public Piece getPiece(int row, int col) {
        //gives the piece at the position
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        //set the piece at the specific postion
        board[row][col] = piece;
    }

    // Game functionality methods

    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
            if (getPiece(startRow,startCol).isMoveLegal(this, endRow, endCol)){
                //checks if the move is valid
                //if valid, set the new position of the piece and set the old position to null
                getPiece(startRow,startCol).setPosition(endRow,endCol);
                board[endRow][endCol] = getPiece(startRow,startCol);
                setPiece(startRow,startCol,null);
                setPiece(endRow,endCol,getPiece(endRow,endCol));
                return true;
        }
        return false;
    }

    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        boolean tempBlack = false;
        boolean tempWhite = false;
        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                //loops through all array pieces
                if (board[row][col] != null) {
                    if (board[row][col].getCharacter() == '\u265a') {
                        //checks if the position has a piece and the piece is a king
                        tempBlack = true;
                    }
                }
            }
        }
        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                //loops through all array pieces
                if (board[row][col] != null) {
                    if (board[row][col].getCharacter() == '\u2654') {
                        //checks if the position has a piece and the piece is a king
                        tempWhite = true;
                    }
                }
            }
        }
        if (tempBlack == tempWhite){
            //returns false if both kings are still on the board, game will continue
            return false;
        }
        return true;
        //returns true if one king is dead
    }

    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        String temp= "";
        temp = "  0\u20031\u20032\u20033\u20034\u20035\u20036\u20037 \n";
        //set temp to the first row of numbers
        for (int row = 0; row < 8; row++){
            temp = temp + row;
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == null){
                    //adds a chacter space for spacing when no piece is at that position
                    temp = temp + "|" + "\u2003";
                }else{
                    temp  = temp + "|" + board[row][col];
                    //adds the correct pieces at given positions
                }
            }
            temp = temp + "|\n";
        }
        return temp;
        //returns the whole board all spaced and formatted
    }


    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                board[row][col] = null;
            }
        }
    }

    //Checks whether a move is remotely even legal
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (startRow < 8 && startRow >= 0 && startCol < 8 && startCol >= 0){
            if (endRow < 8 && endRow >= 0 && endCol < 8 && endCol >= 0)
                //checks that start and end positions are within the board's bounds
                if (board[startRow][startCol] != null){
                    if (board[startRow][startCol].getIsBlack() == isBlack){
                        if (board[endRow][endCol] == null || board[endRow][endCol].getIsBlack() != isBlack){
                            //checks that a piece exists at the start position
                            //checks that the piece is the correct color
                            //checks that the end position has no piece or is the other color
                            return true;
                            //returns if the move is remotely valid
                        }
                }
            }
        }
        return false;
        //returns false if any requirements are not met
    }

    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        // Check whether the '' position and 'end' position are adjacent to each other
        if (startRow == endRow + 1 && startCol == endCol
                || startRow == endRow - 1 && startCol == endCol
                || startRow == endRow && startCol == endCol + 1
                || startRow == endRow && startCol == endCol - 1
                || startRow == endRow + 1 && startCol == endCol + 1
                || startRow == endRow + 1 && startCol == endCol - 1
                || startRow == endRow - 1 && startCol == endCol + 1
                || startRow == endRow - 1 && startCol == endCol - 1){
                return true;
        }
        return false;
    }

    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow) {
            if (startCol < endCol) {
                for (int curCol = startCol; curCol < endCol - 1; curCol++) {
                    if (board[startRow][curCol + 1] != null) {
                        //returns move not valid when moving a piece from left to right
                        return false;
                    }
                }
            }

            if (startCol > endCol) {
                for (int curCol = startCol; curCol > endCol + 1; curCol--) {
                    if (board[startRow][curCol - 1] != null) {
                        //returns move not valid when moving a piece from right to left
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
        //returns not valid if not even horizontal move
    }

    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol == endCol) {
            if (startRow < endRow) {
                for (int curRow = startRow; curRow < endRow - 1; curRow++) {
                    if (board[curRow+1][startCol] != null) {
                        //returns that move not valid when moving top to bottom
                        return false;
                    }
                }
            }
            if (startRow > endRow) {
                for (int curRow = startRow; curRow > endRow + 1; curRow--) {
                    if (board[curRow-1][startCol] != null) {
                        //returns that move not valid when moving bottom to top
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
        //returns not valid if move is not even vertical
    }
        // Checks whether a given 'start' and 'end' position are a valid diagonal move.
        // Returns a boolean to signify whether:
        // - The path from 'start' to 'end' is diagonal... change in row and col.
        // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal ( int startRow, int startCol, int endRow, int endCol){
        int tempRow = 0;
        int tempCol = 0;
        if (startRow > endRow) {
            tempRow = startRow - endRow;
        } else {
            tempRow = endRow - startRow;
        }
        if (startCol > endCol) {
            tempCol = startCol - endCol;
        } else {
            tempCol = endCol - startCol;
        }
        //determine how many spaces are between rows and columns to check if they are equal
        //if not equal, then it is not a diagonal move to automatically returns not valid
        if (tempRow == tempCol) {
            while (startRow + 1< endRow && startCol + 1< endCol) {
                if (board[startRow+1][startCol+1] == null) {
                    startRow++;
                    startCol++;
                } else {
                    return false;
                }
                //checks that spaces on the diagonal are null and valid
            }
            while (startRow - 1> endRow && startCol - 1> endCol) {
                if (board[startRow-1][startCol-1] == null) {
                    startRow--;
                    startCol--;
                } else {
                    return false;
                }
                //checks that spaces on the diagonal are null and valid
            }
            while (startRow - 1 > endRow && startCol + 1 < endCol) {
                if (board[startRow-1][startCol+1] == null) {
                    startRow--;
                    startCol++;
                } else {
                    return false;
                }
                //checks that spaces on the diagonal are null and valid
            }
            while (startRow + 1< endRow && startCol - 1> endCol) {
                if (board[startRow+1][startCol-1] == null) {
                    startRow++;
                    startCol--;
                } else {
                    return false;
                }
                //checks that spaces on the diagonal are null and valid
                //checks for all 4 directions of diagonals
            }
            return true;
            //returns valid if when through all spaces and no pieces are in those spaces
        }
        return false;
    }
}

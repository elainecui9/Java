// Names: Elaine Cui and Adam Liu
// x500s: CUI00122 and LIU02390

import java.util.Random;
import java.util.Scanner;

public class MyMaze{
    Cell[][] maze;
    int startRow;
    int endRow;
    //attributes declaration for class
    public MyMaze(int rows, int cols, int startRow, int endRow) {
        //constructor to initialize the maze with cells
        maze = new Cell[rows][cols];
        for (int trow = 0; trow < rows; trow++){
            for (int tcol = 0; tcol < cols; tcol++){
                maze[trow][tcol] = new Cell();
            }
        }
        this.startRow = startRow;
        this.endRow = endRow;
        //initializes the starting row and ending row for the maze, random
    }

    public static MyMaze makeMaze() {
        int rows = 0;
        int cols = 0;
        //prompt the user to enter their desired number of rows
        System.out.println("Enter the number of rows");
        Scanner myScanner1 = new Scanner(System.in);
        rows = myScanner1.nextInt();
        //prompt the user to enter their desired number of columns
        System.out.println("Enter the number of columns");
        Scanner myScanner2 = new Scanner(System.in);
        cols = myScanner2.nextInt();
        //continue prompting the user until they enter a number within the boundary
        while (rows < 5 || rows > 20 || cols < 5 || cols > 20) {
            System.out.println("Invalid. Please enter again. Enter the number of rows");
            Scanner myScanner3 = new Scanner(System.in);
            rows = myScanner3.nextInt();
            System.out.println("Enter the number of columns");
            Scanner myScanner4 = new Scanner(System.in);
            cols = myScanner4.nextInt();
        }
        //set a random starting row and ending row
        Random rand = new Random();
        int startRow = rand.nextInt(rows);
        int endRow = rand.nextInt(rows);
        MyMaze myMaze = new MyMaze(rows, cols, startRow, endRow);
        Stack1Gen myStack = new Stack1Gen<>();
        int[][] tempArr = new int[2][1];
        tempArr[0][0] = startRow;
        tempArr[1][0] = 0;
        //push the initial element onto the stack and update class attributes
        myStack.push(tempArr);
        myMaze.maze[startRow][0].setVisited(true);
        int currentRow = startRow;
        int currentCol = 0;
        while (!myStack.isEmpty()) {
            int[][] topElement = (int[][])myStack.top();
            //choose a random neighbor to the cell
            int temp = rand.nextInt(4);
            //if the top neighbor is not yet visited
            if (currentRow > 0 && myMaze.maze[currentRow - 1][currentCol].getVisited() == false && temp == 0) {
                //remove the wall between the current cell and neighbor cell
                myMaze.maze[currentRow - 1][currentCol].setBottom(false);
                //change current row
                currentRow--;
                int[][] ta = new int[2][1];
                ta[0][0] = currentRow;
                ta[1][0] = currentCol;
                //push the new element onto the stack
                myStack.push(ta);
                //set the new current element as visited
                myMaze.maze[currentRow][currentCol].setVisited(true);
            }
            //if the right neighbor is not yet visited
            if (currentCol < cols - 1 && myMaze.maze[currentRow][currentCol + 1].getVisited() == false && temp == 1) {
                myMaze.maze[currentRow][currentCol].setRight(false);
                currentCol++;
                int[][] ta = new int[2][1];
                ta[0][0] = currentRow;
                ta[1][0] = currentCol;
                myStack.push(ta);
                myMaze.maze[currentRow][currentCol].setVisited(true);
            }
            //if the bottom neighbor is not yet visited
            if (currentRow < rows - 1 && myMaze.maze[currentRow + 1][currentCol].getVisited() == false && temp == 2) {
                myMaze.maze[currentRow][currentCol].setBottom(false);
                currentRow++;
                int[][] ta = new int[2][1];
                ta[0][0] = currentRow;
                ta[1][0] = currentCol;
                myStack.push(ta);
                myMaze.maze[currentRow][currentCol].setVisited(true);
            }
            //if the left neighbor is not yet visited
            if (currentCol > 0 && myMaze.maze[currentRow][currentCol - 1].getVisited() == false && temp == 3) {
                myMaze.maze[currentRow][currentCol - 1].setRight(false);
                currentCol--;
                int[][] ta = new int[2][1];
                ta[0][0] = currentRow;
                ta[1][0] = currentCol;
                myStack.push(ta);
                myMaze.maze[currentRow][currentCol].setVisited(true);
            }
            //if there is a dead end (no unvisited neighbor cells) for any cell not on the edges or corners of the maze
            if (currentCol > 0 && currentCol < cols - 1 && currentRow > 0 && currentRow < rows - 1 && myMaze.maze[currentRow][currentCol - 1].getVisited() == true &&
                    myMaze.maze[currentRow + 1][currentCol].getVisited() == true &&
                    myMaze.maze[currentRow - 1][currentCol].getVisited() == true &&
                    myMaze.maze[currentRow][currentCol + 1].getVisited() == true) {
                //pop the corresponding index from the top of the stack
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                //set the current index back to its original state so that it can move to an unvisited neighbor cell
                int[][] currentIndex = new int[2][1];
                currentIndex = topElement;
                currentRow = currentIndex[0][0];
                currentCol = currentIndex[1][0];
            }

            //if current position is the left edge but not a corner
            if (currentCol == 0 && currentRow > 0 && currentRow < rows - 1 &&
                    myMaze.maze[currentRow + 1][currentCol].getVisited() == true &&
                    myMaze.maze[currentRow - 1][currentCol].getVisited() == true &&
                    myMaze.maze[currentRow][currentCol + 1].getVisited() == true) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                int[][] currentIndex = new int[2][1];
                currentIndex = topElement;
                currentRow = currentIndex[0][0];
                currentCol = currentIndex[1][0];
            }
            //if current position is the bottom left corner
            if (currentCol == 0 && currentRow == rows - 1 &&
                    myMaze.maze[currentRow - 1][currentCol].getVisited() == true &&
                    myMaze.maze[currentRow][currentCol + 1].getVisited() == true) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                int[][] currentIndex = new int[2][1];
                currentIndex = topElement;
                currentRow = currentIndex[0][0];
                currentCol = currentIndex[1][0];
            }
            //if current position is the top left corner
            if (currentCol == 0 && currentRow == 0 &&
                    myMaze.maze[currentRow + 1][currentCol].getVisited() == true &&
                    myMaze.maze[currentRow][currentCol + 1].getVisited() == true) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                int[][] currentIndex = new int[2][1];
                currentIndex = topElement;
                currentRow = currentIndex[0][0];
                currentCol = currentIndex[1][0];
            }
            //if current position is on the top edge but not a corner
            if (currentCol > 0 && currentCol < cols - 1 && currentRow == 0 &&
                    myMaze.maze[currentRow][currentCol - 1].getVisited() == true &&
                    myMaze.maze[currentRow + 1][currentCol].getVisited() == true &&
                    myMaze.maze[currentRow][currentCol + 1].getVisited() == true) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                int[][] currentIndex = new int[2][1];
                currentIndex = topElement;
                currentRow = currentIndex[0][0];
                currentCol = currentIndex[1][0];
            }
            //if current position is the top right corner
            if (currentCol == cols - 1 && currentRow == 0 &&
                    myMaze.maze[currentRow][currentCol - 1].getVisited() == true &&
                    myMaze.maze[currentRow + 1][currentCol].getVisited() == true) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                int[][] currentIndex = new int[2][1];
                currentIndex = topElement;
                currentRow = currentIndex[0][0];
                currentCol = currentIndex[1][0];
            }
            //if current position is on the right edge but not a corner
            if (currentCol == cols - 1 && currentRow > 0 && currentRow < rows - 1 &&
                    myMaze.maze[currentRow][currentCol - 1].getVisited() == true &&
                    myMaze.maze[currentRow + 1][currentCol].getVisited() == true &&
                    myMaze.maze[currentRow - 1][currentCol].getVisited() == true) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                int[][] currentIndex = new int[2][1];
                currentIndex = topElement;
                currentRow = currentIndex[0][0];
                currentCol = currentIndex[1][0];
            }
            //if current position is the bottom right corner
            if (currentCol == cols - 1 && currentRow == rows - 1 &&
                    myMaze.maze[currentRow][currentCol - 1].getVisited() == true &&
                    myMaze.maze[currentRow - 1][currentCol].getVisited() == true) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                int[][] currentIndex = new int[2][1];
                currentIndex = topElement;
                currentRow = currentIndex[0][0];
                currentCol = currentIndex[1][0];
            }
            //if current position is on the bottom edge but not a corner
            if (currentCol > 0 && currentCol < cols - 1 && currentRow == rows - 1 &&
                    myMaze.maze[currentRow][currentCol - 1].getVisited() == true &&
                    myMaze.maze[currentRow - 1][currentCol].getVisited() == true &&
                    myMaze.maze[currentRow][currentCol + 1].getVisited() == true) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                int[][] currentIndex = new int[2][1];
                currentIndex = topElement;
                currentRow = currentIndex[0][0];
                currentCol = currentIndex[1][0];
            }
        }
        //set the visited attribute of each cell to false
        for (int row = 0; row < myMaze.maze.length; row++ ){
            for(int col=0;col<myMaze.maze[0].length;col++){
                myMaze.maze[row][col].setVisited(false);
            }
        }
        return myMaze;
    }

    public void printMaze() {
        //prints out a representation of what hte maze looks like with visited spots having an "*"
        for (int temp = 0; temp < maze[0].length; temp++){
            System.out.print("|---");
        }
        System.out.println("|");
        //prints out the first line of top border
        int row = 0;
        int col = 0;
        for ( row = 0; row < maze.length; row++){
            //iterate through each row to check what needs to be printed
            for ( col = 0; col < maze[0].length; col++){
                //iterate through checking if the maze at this spot is visited or has a right barrier
                if (col == 0 && maze[row][col] != maze[startRow][0]  ){
                    //adds the left boundary and space where the maze starts
                    System.out.print("|");
                }else if (col == 0) {
                    System.out.print(" ");
                }
                if (maze[row][col].getVisited()){
                    //adds a star to where the maze spot is visited
                    System.out.print(" * ");
                }
                else {
                    System.out.print("   ");
                }
                if (col != maze[0].length - 1) {
                    if (maze[row][col].getRight()) {
                        //adds a right barrier
                        System.out.print("|");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
            if (maze[row][col-1] != maze[endRow][maze[0].length -1]) {
                //adds the left boundary but no boundary at the end spot
                System.out.print("|");
            }
            System.out.println();
            col = 0;
            for ( col = 0; col < maze[0].length; col++) {
                //prints the bottom boundary or barrier of each row
                if (maze[row][col].getBottom()) {
                    System.out.print("|---");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public void solveMaze() {
        //find a path to solve the maze while changing the spots into visited or not
        Q1Gen myQueue = new Q1Gen();
        int[][] tempArr = new int[2][1];
        tempArr[0][0] = startRow;
        tempArr[1][0] = 0;
        myQueue.add(tempArr);
        //add the first starting value into the queue
        while (myQueue.length() != 0){
            //loop until nothing is left in the queue
            int[][] index = new int[2][1];
            index = (int[][]) myQueue.remove();
            int row = index[0][0];
            int col = index[1][0];
            this.maze[row][col].setVisited(true);
            //dequeue the front of the queue
            if (row == endRow && col == this.maze[0].length -1){
                //stop the loop if hits the ending position
                break;
            }
            if (row > 0 && !this.maze[row - 1][col].getBottom() && !this.maze[row - 1][col].getVisited()) {
                //queue the top neighbor if there is one and isn't visited
                int[][] temp = new int[2][1];
                temp[0][0] = row - 1;
                temp[1][0] = col;
                myQueue.add(temp);
            }
            if (row < this.maze.length && !this.maze[row][col].getBottom() && !this.maze[row + 1][col].getVisited()) {
                //queue the bottom neighbor if there is one and isn't visited
                int[][] temp = new int[2][1];
                temp[0][0] = row + 1;
                temp[1][0] = col;
                myQueue.add(temp);
            }
            if (col > 0 && !this.maze[row][col - 1].getRight() && !this.maze[row][col - 1].getVisited()) {
                //queue the left neighbor if there is one and isn't visited
                int[][] temp = new int[2][1];
                temp[0][0] = row;
                temp[1][0] = col - 1;
                myQueue.add(temp);
            }
            if (col < this.maze[0].length && !this.maze[row][col].getRight() && !this.maze[row][col + 1].getVisited()) {
                //queue the right neighbor if there is one and isn't visited
                int[][] temp = new int[2][1];
                temp[0][0] = row;
                temp[1][0] = col + 1;
                myQueue.add(temp);
            }
        }
    }
}
public class Matrix {
    private int nrows;
    private int ncols;
    private int[][] matrix;
    public Matrix(int nrows, int ncols){
        this.nrows = nrows;
        this.ncols = ncols;
        matrix = new int[nrows][ncols];
    }
    public Matrix(int[][] arr){
        nrows = arr.length;
        ncols = arr[0].length;
        matrix = arr;

    }
    public Matrix transpose(){
        Matrix newMatrix = new Matrix(ncols,nrows);
        for (int x = 0; x < ncols; x++){
            for (int y = 0 ; y < nrows; y++){
                newMatrix.matrix[x][y] = this.matrix[y][x];
            }
        }
        return newMatrix;
    }
    public String toString(){
        String temp="";
        for (int x = 0; x < nrows; x++) {
            for (int y = 0; y < ncols; y++) {
                temp = temp +  "* ";
            }
            temp = temp + "\n";
        }
        return temp;
    }
    public static void main(String[] args){
        Matrix m = new Matrix(2,10);
        System.out.println(m.toString());
        Matrix newm = m.transpose();
        System.out.println(newm.toString());
    }
}

import java.util.*;
public class ColorPath {
    public static int[][] colorPath(int[][] image, int sourceRow, int sourceCol, int newColor){
        bfs(image, sourceRow,sourceCol,image[sourceRow][sourceCol],newColor);
        dfs(image, sourceRow,sourceCol,image[sourceRow][sourceCol],newColor);
        return image;
    }
    public static void bfs(int[][] image, int row, int col, int originalcolor, int newcolor){
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = new int[2];
        arr[0] = row;
        arr[1] = col;
        queue.add(arr);
        while (!queue.isEmpty()){
            int[] temparr = queue.remove();
            image[temparr[0]][temparr[1]] = newcolor;
            if (temparr[0] -1 >= 0 && image[temparr[0]-1][temparr[1]] == originalcolor ) {
                int[] temp = new int[2];
                temp[0] = temparr[0] -1;
                temp[1] = temparr[1];
                queue.add(temp);
            }
            if (temparr[0] +1 < image[0].length && image[temparr[0]+1][temparr[1]] == originalcolor ) {
                int[] temp = new int[2];
                temp[0] = temparr[0] +1;
                temp[1] = temparr[1];
                queue.add(temp);
            }
            if (temparr[1] -1 >= 0 && image[temparr[0]][temparr[1]-1] == originalcolor ) {
                int[] temp = new int[2];
                temp[0] = temparr[0] ;
                temp[1] = temparr[1]-1;
                queue.add(temp);
            }
            if (temparr[1] +1 < image[0].length && image[temparr[0]][temparr[1]+1] == originalcolor ) {
                int[] temp = new int[2];
                temp[0] = temparr[0] ;
                temp[1] = temparr[1] +1;
                queue.add(temp);
            }
        }
    }
    public static void dfs(int[][] image, int row, int col, int originalcolor, int newcolor) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != originalcolor) {
            return;
        } else {
            image[row][col] = newcolor;
            dfs(image, row - 1, col, originalcolor, newcolor);
            dfs(image, row + 1, col, originalcolor, newcolor);
            dfs(image, row, col - 1, originalcolor, newcolor);
            dfs(image, row, col + 1, originalcolor, newcolor);
            }
         }
    }

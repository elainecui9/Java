import java.util.*;

public class PathExists {
    public static boolean doesPathExist(char[][] grid, int sourceRow, int sourceCol) {
        bfs(grid, sourceRow, sourceCol, 'o');
        for (int x= 0; x < grid[0].length; x++){
            for (int y = 0; y < grid.length; y++){
                if(grid[x][y] == 'v'){
                    return false;
                }
            }
        }
        dfs(grid, sourceRow, sourceCol, 'o');
        for (int x= 0; x < grid[0].length; x++){
            for (int y = 0; y < grid.length; y++){
                if(grid[x][y] == 'v'){
                    return false;
                }
            }
        }
        return true;
    }
        public static void bfs(char[][] grid, int row, int col, char original){
            Queue<int[]> queue = new LinkedList<>();
            int[] arr = new int[2];
            arr[0] = row;
            arr[1] = col;
            queue.add(arr);
            while (!queue.isEmpty()){
                int[] temparr = queue.remove();
                grid[temparr[0]][temparr[1]] = original;
                if (temparr[0] -1 >= 0 ){
                    if(grid[temparr[0]-1][temparr[1]] == 'p' || grid[temparr[0]-1][temparr[1]] == 'v') {
                        int[] temp = new int[2];
                        temp[0] = temparr[0] - 1;
                        temp[1] = temparr[1];
                        queue.add(temp);
                    }
                }
                if (temparr[0] +1 < grid[0].length && temparr[0] + 1 >= 0 ){
                    if (grid[temparr[0]+1][temparr[1]] == 'p'|| grid[temparr[0]+1][temparr[1]] == 'v' ) {
                        int[] temp = new int[2];
                        temp[0] = temparr[0] + 1;
                        temp[1] = temparr[1];
                        queue.add(temp);
                    }
                }
                if (temparr[1] -1 >= 0 ){
                    if (grid[temparr[0]][temparr[1]-1] == 'p'|| grid[temparr[0]][temparr[1]-1] == 'v' ) {
                        int[] temp = new int[2];
                        temp[0] = temparr[0];
                        temp[1] = temparr[1] - 1;
                        queue.add(temp);
                    }
                }
                if (temparr[1] +1 < grid[0].length && temparr[1] + 1 >=0){
                    if (grid[temparr[0]][temparr[1]+1] == 'p'|| grid[temparr[0]][temparr[1]+1] == 'v' ) {
                        int[] temp = new int[2];
                        temp[0] = temparr[0];
                        temp[1] = temparr[1] + 1;
                        queue.add(temp);
                    }
                }
            }
        }
        public static void dfs(char[][] grid, int row, int col, char original) {
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 'p'|| grid[row][col] != 'v') {
                return;
            } else {
                grid[row][col] = original;
                dfs(grid, row - 1, col, original);
                dfs(grid, row + 1, col, original);
                dfs(grid, row, col - 1, original);
                dfs(grid, row, col + 1, original);
            }
        }

}

public class Count {
    public int countHazard(char[][] a, char hazard){
        int count = 0;
        for(int x = 0; x <a.length; x++){
            for(int y = 0; y < a[0].length; y++){
                if (a[x][y] == hazard){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        char[][] arr = new char[3][5];
        arr[0][0] = 'a';
        arr[0][1] = 'x';
        arr[0][2] = 'c';
        arr[0][3] = 'd';
        arr[0][4] = 'e';
        arr[1][0] = '1';
        arr[1][1] = 'x';
        arr[1][2] = '3';
        arr[1][3] = '4';
        arr[1][4] = 'x';
        arr[2][0] = 'a';
        arr[2][1] = '1';
        arr[2][2] = 'b';
        arr[2][3] = '2';
        arr[2][4] = '3';
        Count hi = new Count();
        System.out.println(hi.countHazard(arr,'a'));
    }
}

public class Histogram {
    private int low;
    private int upper;
    private int[] array;

    public Histogram (int lowerbound, int upperbound){
        low = lowerbound;
        upper = upperbound;
        array = new int[upper - low + 1 ];
    }
    public boolean add(int i){
        if (i >= low && i <= upper){
            array[i - low] = array[i - low] + 1;
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String num = "";
        for (int x = 0; x < upper - low + 1; x++){
            num = num + (low + x) + ":";
            int temp = array[x];
            for (int y = 0; y < temp; y++)
            {
                num = num + "*";
            }
            num = num + "\n";
        }
       return num;
    }
    public static void main(String[] args){
        Histogram histo = new Histogram(0, 5);
        histo.add(3);
        histo.add(2);
        histo.add(1);
        histo.add(2);
        histo.add(3);
        histo.add(0);
        histo.add(1);
        histo.add(5);
        histo.add(3);
        System.out.println(histo);
    }
}
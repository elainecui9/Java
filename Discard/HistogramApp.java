import java.util.Scanner;
public class HistogramApp {
    public HistogramApp(){

    }
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the lowerbound:");
        int lb = myScanner.nextInt();
        System.out.println("Please enter the upperbound:");
        int ub = myScanner.nextInt();
        Histogram histo = new Histogram(lb, ub);
        int x = 1;
        while(x == 1){
            System.out.println("Please enter a command:");
            String command = myScanner.nextLine();
            command = myScanner.nextLine();
            if (command.equals("add")){
                System.out.println("Enter number:");
                int temp = myScanner.nextInt();
                if (temp <= lb ||temp >= ub){
                    System.out.println("That is not in the bounds.");
                }else{
                histo.add(temp);
                }
            }
            if (command.equals("print")){
                System.out.println(histo.toString());
            }
            if (command.equals("quit")){
                System.out.println("Bye");
                x = 0;
            }
        }
    }
}

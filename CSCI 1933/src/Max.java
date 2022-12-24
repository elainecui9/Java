import java.util.Scanner;
public class Max {
    public Max(){

    }
    public static int recursiveMaxDigit(int num){
        int temp = 0;
        if (num == 0){
            return num;
        }
        else{
            temp = num % 10;
            int newnum = recursiveMaxDigit(num/10);
            if (temp > newnum){
                newnum = temp;
            }
            return newnum;
        }
    }
    public static int iterativeMaxDigit(int num){
        int max = 0;
        int temp = 0;
        while (num > 0){
            temp = num % 10;
            if (temp > max){
                max = temp;
            }
            num = num / 10;
        }
        return max;
    }
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter in your number:");
        int number = myScanner.nextInt();
        System.out.println("The greatest number using recursiveMaxDigit is: " + recursiveMaxDigit(number));
        System.out.println("The greatest number using iterativeMaxDigit is: " + iterativeMaxDigit(number));
    }
}

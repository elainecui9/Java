import java.util.Scanner;
public class Fib {
    public Fib()
    {
    }
    public static int fibonacciRecursive(int n){
        if (n == 0)
        {
            return 0;
        }
        else if (n == 1)
        {
            return 1;
        }
        else{
            return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
        }
    }
    public static int fibonacciIterative(int n){
        int secondNum = 0;
        int firstNum = 0;
        int currentNum = 1;
        for (int x = 0; x < n-1; x++){
            secondNum = firstNum;
            firstNum = currentNum;
            currentNum = secondNum + firstNum;
        }
        if (n == 0){
            return 0;
        }
        return currentNum;
    }
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter an integer n to get the n'th Fibonacci number:");
        int number = myScanner.nextInt();
        if (number >= 0){
            System.out.println("The " + number + "'th Fibonacci number using fibonacciRecursive is " + fibonacciRecursive(number));
            System.out.println("The " + number + "'th Fibonacci number using fibonacciIterative is " + fibonacciIterative(number));
        }
        else {
            System.out.println("You entered a negative number.");
        }


    }
}

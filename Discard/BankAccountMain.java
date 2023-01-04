import java.util.Scanner;
public class BankAccountMain {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        Scanner myScanner2 = new Scanner(System.in);
        BankAccount myAccount = new BankAccount("Java", "CSCI1933 rules!", 1000);
        BankAccount myAccount2 = new BankAccount("Java", "CSCI1933 ruless!", 100);
        System.out.println("Enter your password?");
        String tempPass = myScanner.nextLine();
        System.out.println("My account's balance is: " + myAccount.getBalance(tempPass));
        System.out.println("How much would you like to transfer:");
        double temp = myScanner.nextDouble();
        System.out.println("Enter your password?");
        String newtempPass = myScanner2.nextLine();
        myAccount.transfer(myAccount2, newtempPass, temp);
        System.out.println(myAccount.getBalance("CSCI1933 rules!"));
        System.out.println(myAccount2.getBalance("CSCI1933 ruless!"));

    }
}

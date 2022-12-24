import java.util.Scanner;
public class BankAccount {
    private String name;
    private String password;
    private double balance;

    public BankAccount(String initName, String initPass, double initBalance){
        this.name = initName;
        this.password = initPass;
        this.balance = initBalance;
    }

    public void withdraw(String enteredPassword, double amount){
        if (password.equals(enteredPassword) && balance >= amount){
            balance = balance - amount;
        }
    }
    public void deposit(String enteredPassword, double amount){
        if (password.equals(enteredPassword)) {
            balance = balance + amount;
        }
    }
    public double getBalance(String enteredPassword){
        if (password.equals(enteredPassword)){
            return balance;
        }
        else {
            return -1;
        }
    }
    public boolean setPassword(String oldPassword, String newPassword){
        if (password.equals(oldPassword)){
            password = newPassword;
            return true;
        } else {
            return false;
        }
    }
    public void setName(String newName){
        this.name = newName;
    }
    public String getName(){
        return name;
    }
    public void transfer(BankAccount other, String enteredPassword, double amount){
        if (password.equals(enteredPassword)){
            withdraw(enteredPassword, amount);
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Please enter the other bank account's password: ");
            String temp = myScanner.nextLine();
            if (temp.equals(other.password)){
                other.deposit(temp, amount);
            } else {
                deposit(enteredPassword, amount);
            }

        }
    }
}

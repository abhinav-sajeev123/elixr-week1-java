package oops.encapsulation;

import java.util.Scanner;

public class BankAccount {

    private double balance=0;

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully"+amount);
        }
        else {
            System.out.println("invalid amount to deposit");
        }
    }
    
    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("Invalid amount to withdraw");
        } else if (amount>balance) {
            System.out.println("Insufficient balance");
            
        }
        else{
            balance-=amount;
            System.out.println("Amount withdrawn successfully "+amount);
        }
    }
    public double getBalance(){
        return balance;
    }
}

class Main {
    public static void main(String[] args) {

        BankAccount bank = new BankAccount();

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("BANK MENU");
            System.out.println("Enter your choice");
            System.out.println("1. View balance");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Exit");
            choice= sc.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("your balance is " + bank.getBalance());
                    break;

                case 2:
                    System.out.println("enter amount to deposit");
                    double depositAmount=sc.nextDouble();
                    bank.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("enter amount to withdraw");
                    double withdrawAmount=sc.nextDouble();
                    bank.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Exiting....thanks for visiting");
                    break;

                default:
                    System.out.println("Invalid choice, please try again");
            }

        }while (choice!=4);
            sc.close();

    }
}

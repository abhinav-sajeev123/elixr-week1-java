package oops.exercise;
import java.util.Scanner;

abstract class Account {

    private double balance = 0;

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public double getBalance() {
        return balance;
    }

    protected void deductBalance(double amount) {
        balance -= amount;
    }

    abstract void withdraw(double amount);
}

class SavingsAccount extends Account {

    @Override
    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount");
        } else if (amount > getBalance()) {
            System.out.println("Insufficient Balance");
        } else {
            deductBalance(amount);
            System.out.println("Withdrawn from Savings: " + amount);
        }
    }
}

class CurrentAccount extends Account {

    @Override
    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount");
        } else if (amount > getBalance()) {
            System.out.println("Insufficient Balance");
        } else {
            deductBalance(amount);
            System.out.println("Withdrawn from Current: " + amount);
        }
    }
}

public class Bank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Account");
        System.out.println("1. Savings");
        System.out.println("2. Current");

        int type = sc.nextInt();

        Account acc;

        switch (type) {

            case 1:
                acc = new SavingsAccount();
                break;

            case 2:
                acc = new CurrentAccount();
                break;

            default:
                System.out.println("Invalid Account Type");
                sc.close();
                return;
        }

        int choice;

        do {

            System.out.println("\nBANK MENU");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Amount: ");
                    double deposit = sc.nextDouble();
                    acc.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    double withdraw = sc.nextDouble();
                    acc.withdraw(withdraw);
                    break;

                case 3:
                    System.out.println("Balance: " + acc.getBalance());
                    break;

                case 4:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}

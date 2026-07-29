package exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 0;
        double amount;
        double deductAmount;
        try {
            System.out.println("Enter amount to deposit: ");
            amount = sc.nextDouble();
            balance += amount;
            System.out.println(amount + " deposited successfully");
            System.out.println("Enter amount to withdraw : ");
            deductAmount = sc.nextDouble();
            if (deductAmount > balance) {
                throw new IllegalArgumentException("Insufficient balance, your balance is :" + balance);
            } else {
                balance -= deductAmount;
            }
            System.out.println("Withdrawal success with balance amount : " + balance);

        } catch (InputMismatchException e) {
            System.out.println("Please enter numbers only");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Thanks for your service");
            sc.close();
        }
        System.out.println("Have a good day");
    }
}

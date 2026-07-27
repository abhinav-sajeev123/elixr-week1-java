package oops.polymorphism;
import java.util.Scanner;
//compile time polymorphism(overloading)
class Operations{
    void add(int a, int b){
        System.out.println("addition is : "+(a+b));
    }

    void add(int a,int b,int c){
        System.out.println("addition is : "+(a+b+c));
    }
}
public class Calculator {
    public static void main(String[] args) {
        Operations op=new Operations();
        Scanner sc=new Scanner(System.in);
        int choice;

        do{
            System.out.println("OPERATIONS");
            System.out.println("1. Add two numbers");
            System.out.println("2. Add three numbers");
            System.out.println("3. Exit");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter first number");
                    int a=sc.nextInt();
                    System.out.println("Enter second number");
                    int b=sc.nextInt();
                    op.add(a,b);
                    break;

                case 2:
                    System.out.println("Enter first number");
                    int num1=sc.nextInt();
                    System.out.println("Enter second number");
                    int num2=sc.nextInt();
                    System.out.println("Enter third number");
                    int num3=sc.nextInt();
                    op.add(num1,num2,num3);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }while (choice!=3);
        sc.close();
    }
}

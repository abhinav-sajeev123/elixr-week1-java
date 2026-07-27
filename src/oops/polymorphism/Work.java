package oops.polymorphism;
import java.util.Scanner;
//run time polymorphism(overriding)
class Employee{
    void work(){
        System.out.println("Employee working...");
    }
}

class Manager extends Employee{
    @Override
    void work(){
        System.out.println("Manager Working....");
    }
}

class Developer extends Employee{
    @Override
    void work() {
        System.out.println("Developer working....");;
    }
}
public class Work {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        Employee emp;
        do {
            System.out.println("Enter your choice");
            System.out.println("1. Manager");
            System.out.println("2. Developer");
            System.out.println("3. Exit");
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    emp=new Manager();
                    emp.work();
                    break;

                case 2:
                    emp=new Developer();
                    emp.work();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    emp=new Employee();
                    emp.work();

            }
        }while (choice!=3);
        sc.close();

    }
}

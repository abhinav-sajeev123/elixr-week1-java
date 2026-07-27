package oops.abstraction;
import java.util.Scanner;
//abstract

abstract class Vehicle{
   abstract void start();

   void stop(){
       System.out.println("stopped");
   }
}

class Bike extends Vehicle{

    @Override
    void start() {
        System.out.println("Bike starting...");
    }
}

class Car extends Vehicle{

    @Override
    void start() {
        System.out.println("Car starting...");
    }
}
public class Toys {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        Vehicle vehicle;
        do {
            System.out.println("Enter your choice");
            System.out.println("1. Bike");
            System.out.println("2. Car");
            System.out.println("3. Exit");
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    vehicle = new Bike();
                    vehicle.start();
                    vehicle.stop();
                    break;

                case 2:
                    vehicle = new Car();
                    vehicle.start();
                    vehicle.stop();
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

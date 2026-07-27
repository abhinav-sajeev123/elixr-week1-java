package oops.abstraction;
import java.util.Scanner;
//interface

interface Call{
    void call();
}
interface Music{
    void music();
}

class Mobile implements Call,Music{

    @Override
    public void call() {
        System.out.println("Calling is allowed");
    }

    @Override
    public void music() {
        System.out.println("Playing the music album");

    }

    void game(){
        System.out.println("Playing games");
    }
}
public class SmartPhone  {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        Mobile mobile=new Mobile();
        int choice;
        do {
            System.out.println("Enter your choice");
            System.out.println("1. Call friend");
            System.out.println("2. Play the song");
            System.out.println("3. Game");
            System.out.println("4. Exit");
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    mobile.call();
                    break;

                case 2:
                    mobile.music();
                    break;

                case 3:
                    mobile.game();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        }while (choice!=4);
        sc.close();
    }
}

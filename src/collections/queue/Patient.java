package collections.queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Patient {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();

        int choice;

        do {

            System.out.println("1. Add patient");
            System.out.println("2. Serve patient");
            System.out.println("3. View Next patient");
            System.out.println("4. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    queue.add(name);
                    System.out.println("Patient Added");
                    break;

                case 2:
                    if(!queue.isEmpty()) {
                        System.out.println("Serving: " + queue.remove());
                    } else {
                        System.out.println("Queue Empty");
                    }
                    break;

                case 3:
                    if(!queue.isEmpty()) {
                        System.out.println("Next patient: " + queue.peek());
                    } else {
                        System.out.println("Queue Empty");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 4);
        sc.close();
    }
}
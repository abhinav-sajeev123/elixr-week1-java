package collections.stack;
import java.util.Scanner;
import java.util.Stack;

public class History {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> history = new Stack<>();
        int choice;

        do {

            System.out.println("BROWSER MENU");
            System.out.println("1. Visit Website");
            System.out.println("2. Back");
            System.out.println("3. Current Website");
            System.out.println("4. View History");
            System.out.println("5. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Website: ");
                    String site = sc.nextLine();
                    history.push(site);
                    System.out.println("Website Added");
                    break;

                case 2:
                    if (!history.isEmpty()) {
                        System.out.println("Back From: "+ history.pop());
                    } else {
                        System.out.println("No History");
                    }
                    break;

                case 3:

                    if (!history.isEmpty()) {
                        System.out.println("Current Website: "+ history.peek());
                    } else
                    {
                        System.out.println(
                                "No Website Open");
                    }
                    break;

                case 4:
                    if(!history.isEmpty()){
                        System.out.println("Your history");
                        for (String h:history){
                            System.out.println(h);
                        }
                    }else {
                        System.out.println("History is empty");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
        sc.close();
    }
}

package collections.set;

import java.util.Scanner;
import java.util.TreeSet;

public class Color {
    public static void main() {
        Scanner sc=new Scanner(System.in);
        TreeSet<String>color=new TreeSet<>();
        int choice;
        do{
            System.out.println("Enter your choice");
            System.out.println("1. Enter the color");
            System.out.println("2. View the color");
            System.out.println("3. Search the color");
            System.out.println("4. Exit");
            choice=sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:

                        if(color.add(sc.nextLine())){
                        System.out.println("color added successfully");
                    }else {
                        System.out.println("color already exists");
                    }
                    break;

                case 2:
                    if(!color.isEmpty()) {
                        System.out.println("Colors you added are : ");
                        for (String colors : color) {
                            System.out.println(colors);
                        }
                    }else{
                        System.out.println("No colors exist in this list");
                    }
                    break;

                case 3:
                    if(!color.isEmpty()){
                        System.out.println("Search the color you wanted");
                        String checkColor=sc.nextLine();
                        if(color.contains(checkColor)){
                            System.out.println("The "+checkColor+" is present");
                        }else {
                            System.out.println("The "+checkColor+" is not present");
                        }

                    }else {
                        System.out.println("No color in this list");
                    }
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

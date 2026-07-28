package collections.set;

import java.util.HashSet;
import java.util.Scanner;

public class Visitor {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        HashSet<String>visitors=new HashSet<>();
        int choice;
        do{
            System.out.println("VISITORS MENU");
            System.out.println("1. Add visitor");
            System.out.println("2. View visitors");
            System.out.println("3. Check visitor");
            System.out.println("4. Remove visitor");
            System.out.println("5. Total visitors");
            System.out.println("6. Remove all visitors");
            System.out.println("7. Exit");

            choice=sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter visitor name : ");
                    String name=sc.nextLine();
                    if(visitors.add(name)){
                        System.out.println("Visitor "+name+" added successfully");
                    }
                    else{
                        System.out.println("Visitor "+name+" already exists");
                    }
                    break;

                case 2:
                    if(!visitors.isEmpty()){
                        for(String v:visitors){
                            System.out.println(v);
                        }
                    }else{
                        System.out.println("No visitors found");
                    }
                     break;

                case 3:
                    System.out.println("Enter name of visitor to check : ");
                    String checkName=sc.nextLine();
                    if(visitors.contains(checkName)){
                        System.out.println(checkName+" is found");
                    }
                    else{
                        System.out.println(checkName+" is not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter visitor name to remove : ");
                    String removeName=sc.nextLine();
                    if(!visitors.contains(removeName)){
                        System.out.println(removeName+" visitor not found ");
                    }else {
                        visitors.remove(removeName);
                        System.out.println(removeName+" removed");
                    }
                    break;

                case 5:
                    if(visitors.isEmpty()){
                        System.out.println("No visitors found");
                    }
                    else {
                        System.out.println("Total visitors : "+visitors.size());
                    }
                    break;

                case 6:
                    if(visitors.isEmpty()){
                        System.out.println("No visitors found ");
                    }
                    else {
                        visitors.clear();
                        System.out.println("Removed all visitors");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");

                default:
                    System.out.println("Invalid choice");

            }

        }while (choice!=7);
        sc.close();

    }
}

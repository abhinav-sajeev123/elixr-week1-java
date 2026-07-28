package collections.list;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        ArrayList<String>names=new ArrayList<>();
        int choice;

        do {
            System.out.println("STUDENT MANAGEMENT");
            System.out.println("1. Add student");
            System.out.println("2. View students");
            System.out.println("3. Update student");
            System.out.println("4. Remove student");
            System.out.println("5. Total students");
            System.out.println("6.Exit");

            choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter student name");
                    String name=sc.nextLine();
                    names.add(name);
                    System.out.println("Student "+name+" added successfully");
                    break;

                case 2:
                    System.out.println("Students list");
                    for(String n:names){
                        System.out.println(n);
                    }
                    break;

                case 3:
                    System.out.println("Enter the index : ");
                    int index=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new name of student : ");
                    String newName=sc.nextLine();
                    names.set(index,newName);
                    System.out.println("Name updated successfully");
                    break;

                case 4:
                    if(!names.isEmpty()){
                    System.out.println("Enter name of student to remove");
                    String removingName=sc.nextLine();
                    names.remove(removingName);
                    System.out.println(removingName+" removed successfully");}
                    else {
                        System.out.println("Student list is empty");
                    }
                    break;

                case 5:
                    System.out.println("Total no of students are : "+names.size());
                    break;

                case 6:
                    System.out.println("Exiting...");

                default:
                    System.out.println("Invalid choice,please try again.");
            }
        }while (choice!=6);
        sc.close();

    }
}

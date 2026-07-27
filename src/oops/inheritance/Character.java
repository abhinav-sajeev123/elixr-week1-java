package oops.inheritance;

import java.util.Scanner;

class Person {
     String name;

    public void setName(String name){
        this.name=name;
    }

    public void displayName(){
        System.out.println("Name :"+name);
    }
}

class Student extends Person{
    public void study(){
        System.out.println(name+" is studying..");
    }
}

class Employee extends Person{
    public void work(){
        System.out.println(name+" is working...");
    }
}

class Teacher extends Employee{
    public void teach(){
        System.out.println(name+" is teaching..");
    }
}

public class Character {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int choice;
        do{
            System.out.println("Enter your choice");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Exit");

            choice=sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    Student student=new Student();
                    System.out.println("Enter student name");
                    student.setName(sc.nextLine());
                    student.displayName();
                    student.study();
                    break;

                case 2:
                    Teacher teacher=new Teacher();
                    System.out.println("Enter teacher name");
                    teacher.setName(sc.nextLine());
                    teacher.displayName();
                    teacher.work();
                    teacher.teach();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        }while(choice!=3);
        sc.close();
    }
}

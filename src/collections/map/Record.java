package collections.map;

import java.util.HashMap;
import java.util.Scanner;

public class Record {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        HashMap<Integer, String> record = new HashMap<>();
        do {
            System.out.println("STUDENT RECORD");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the id : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if(!record.containsKey(id)) {
                        System.out.println("Enter the name : ");
                        String name = sc.nextLine();
                        record.put(id, name);
                        System.out.println("Student with id " + id + " and name " + name + " added successfully");
                    }
                    else{
                        System.out.println("Student with this "+id+" already exists");
                    }
                    break;

                case 2:
                    if (!record.isEmpty()) {
                        System.out.println("Students are : ");
                        for (int n : record.keySet()) {
                            System.out.println(n + " : " + record.get(n));
                        }
                    } else {
                        System.out.println("No records found");
                    }
                    break;

                case 3:
                    System.out.println("Enter the id of student : ");
                    int stuId = sc.nextInt();
                    sc.nextLine();
                    if (record.containsKey(stuId)) {
                        System.out.println("Student founded : " + record.get(stuId));
                    } else {
                        System.out.println("Student with "+stuId + " not found");
                    }
                    break;

                case 4:
                    if (!record.isEmpty()) {
                        System.out.println("Enter the id to remove : ");
                        int removeId = sc.nextInt();
                        sc.nextLine();
                        if (record.containsKey(removeId)) {
                            record.remove(removeId);
                            System.out.println("Student with " + removeId + " is removed");
                        } else {
                            System.out.println(removeId + " not exist in record");
                        }
                    } else {
                        System.out.println("No records found");
                    }
                    break;

                case 5:
                    if (!record.isEmpty()) {
                        System.out.println("Enter id to update : ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        if (record.containsKey(updateId)) {
                            System.out.println("Enter new name");
                            String updateName = sc.nextLine();
                            record.put(updateId, updateName);
                            System.out.println("Student with " + updateId + " updated to " + updateName);
                        } else {
                            System.out.println(updateId + " with student not found");
                        }

                    } else {
                        System.out.println("Record is empty");
                    }
                    break;

                case 6:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);
        sc.close();

    }
}

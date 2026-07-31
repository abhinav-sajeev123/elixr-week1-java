package java_8;
import java.util.*;
import java.util.stream.Collectors;

public class Salary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Double> salaries = new ArrayList<>();
        int choice;

        do {
            System.out.println(" EMPLOYEE SALARY MENU");
            System.out.println("1. Add Salary");
            System.out.println("2. View Salaries");
            System.out.println("3. Salaries Above 3000");
            System.out.println("4. Increase Salary by 5000");
            System.out.println("5. Total Salary");
            System.out.println("6. Exit");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Salary: ");
                    salaries.add(sc.nextDouble());
                    break;

                case 2:
                    if(!salaries.isEmpty()) {
                        salaries.forEach(System.out::println);
                    }else {
                        System.out.println("Nothing found here");
                    }
                    break;

                case 3:
                    if(!salaries.isEmpty())
                    {
                        System.out.println("Salaries above 3000 are : ");
                        salaries.stream()
                                .filter(salary -> salary > 3000)
                                .forEach(System.out::println);
                    }else {
                        System.out.println("No salaries found");
                    }
                    break;

                case 4:
                    if(!salaries.isEmpty()) {
                        salaries=salaries.stream()
                                .map(salary -> salary + 5000)
                                .collect(Collectors.toList());
                        salaries.forEach(System.out::println);
                        System.out.println("Salaries incremented successfully");
                    }else {
                        System.out.println("No salaries found to increment");
                    }
                    break;

                case 5:
                    Double total = salaries.stream()
                            .reduce(0.0,Double::sum);
                    System.out.println("Total Salary = " + total);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 6);
        sc.close();
    }
}

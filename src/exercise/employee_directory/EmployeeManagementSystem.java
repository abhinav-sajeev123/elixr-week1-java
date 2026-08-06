package exercise.employee_directory;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {

    static Map<String,Employee>employee=new HashMap<>();
    static Scanner sc=new Scanner(System.in);

    public static void addEmployee(){
        try{
            System.out.println("Enter employee id : ");
            String id=sc.next();
            if(employee.containsKey(id)){
                throw new DuplicateEmployeeException("Employee id "+id+" already exists");
            }
            System.out.println("Enter employee name : ");
            String name=sc.next();

            System.out.println("Enter employee department : ");
            String department=sc.next();

            Employee emp=new Employee(id,name,department);
            employee.put(id,emp);

            System.out.println("Employee added successfully : "+emp);

        }
        catch (DuplicateEmployeeException e){
            System.out.println("Error : "+e.getMessage());
        }
        catch (IllegalArgumentException e){
            System.out.println("Error : "+e.getMessage());
        }
    }

    public static void removeEmployee(){
        System.out.println("Enter employee id to remove : ");
        String id=sc.next();
        if(employee.remove(id)!=null){
            System.out.println("Employee removed successfully.");
        }else{
            System.out.println("Employee not found.");
        }
    }

    public static void searchEmployee(){
        System.out.println("Enter employee id to search for : ");
        String id=sc.next();
        Employee emp=employee.get(id);
        if(emp!=null){
            System.out.println(emp);
        }
        else {
            System.out.println("Employee not found");
        }
    }

    public static void displayEmployee(){
        List<Employee> employees = new ArrayList<>(employee.values());

       employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
    }

    public static void filterEmployees() {

        System.out.print("Enter starting letter: ");
        String letter = sc.next().toUpperCase();

        String result=employee.values()
                .stream()
                .map(Employee::getName)
                .filter(name -> name.toUpperCase().startsWith(letter))
                .collect(Collectors.joining(", "));
        if(result.isEmpty()){
            System.out.println("No employees were found with starting letter "+letter);
        }else {
            System.out.println("Filter " + letter + ": " + result);
        }
    }

    public static void countDepartment() {

        Map<String, Long> count =
                employee.values()
                        .stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        ));

        count.forEach((dept, total) ->
                System.out.println("Total employees in " + dept + ": " + total));
    }


    public static void main(String[] args) {

        while (true) {

            try {

                System.out.println(" Employee Management ");
                System.out.println("1. Add Employee");
                System.out.println("2. Remove Employee");
                System.out.println("3. Search Employee");
                System.out.println("4. Display All Employees");
                System.out.println("5. Filter By Name");
                System.out.println("6. Count Department");
                System.out.println("7. Exit");

                System.out.print("Enter choice: ");

                int choice = sc.nextInt();


                switch (choice) {

                    case 1:
                        addEmployee();
                        break;

                    case 2:
                        removeEmployee();
                        break;

                    case 3:
                        searchEmployee();
                        break;

                    case 4:
                        displayEmployee();
                        break;

                    case 5:
                        filterEmployees();
                        break;

                    case 6:
                        countDepartment();
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }


            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Enter numbers only.");
                sc.nextLine();

            }
        }
    }
}

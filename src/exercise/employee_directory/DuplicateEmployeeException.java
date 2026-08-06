package exercise.employee_directory;

public class DuplicateEmployeeException extends Exception{
    public DuplicateEmployeeException(String message){
        super(message);
    }
}

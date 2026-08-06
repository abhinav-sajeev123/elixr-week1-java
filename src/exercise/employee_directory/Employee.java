package exercise.employee_directory;

public class Employee {
    public String employeeId;
    public String name;
    public String department;

    public Employee(String employeeId,String name,String department){

        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if(department.trim().isEmpty()){
            throw new IllegalArgumentException("Department cannot be blank");
        }
        this.employeeId=employeeId;
        this.name=name;
        this.department=department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "employeeId =" + employeeId +
                " ,name =" + name  +
                " ,department = " + department;
    }
}

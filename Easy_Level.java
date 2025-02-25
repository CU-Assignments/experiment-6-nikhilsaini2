import java.util.ArrayList;
import java.util.List;

class Employee {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmpID: " + empId + ", Name: " + name + ", Salary: " + salary;
    }
}

public class Easy_Level {
    public static void main(String[] args) {
        // Simulating a database with a list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", 50000.00));
        employees.add(new Employee(2, "Jane Smith", 60000.00));

        // Display all employees
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
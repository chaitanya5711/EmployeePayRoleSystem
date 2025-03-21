package hmm;
import java.util.*;

public class PayRole {

    //Abstract Employee class
    abstract class Employee {
        private String name;
        private int id;

        //Constructor
        public Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        // Abstract method
        public abstract double calculateSalary();

        @Override
        public String toString() {
            return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
        }
    }

    // Full-time Employee class
    class Fulltime extends Employee {
        private double monthlySalary;

        // Constructor
        public Fulltime(String name, int id, double monthlySalary) {
            super(name, id);
            this.monthlySalary = monthlySalary;
        }

        public double calculateSalary() {
            return monthlySalary;
        }
    }

    // Part-time Employee class
    class PartEmployee extends Employee {
        private int hoursWorked;
        private double hourlyRate;

        public PartEmployee(String name, int id, int hoursWorked, double hourlyRate) {
            super(name, id);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        public double calculateSalary() {
            return hoursWorked * hourlyRate;
        }
    }

    // Payroll System class
    class Payrolee {
        private ArrayList<Employee> employeeList;

        public Payrolee() {
            employeeList = new ArrayList<>();
        }

        // Adding an employee
        public void addEmployee(Employee employee) {
            employeeList.add(employee);
        }

        // Removing an employee
        public void removeEmployee(int id) {
            Employee remove = null;
            for (Employee employee : employeeList) {
                if (employee.getId() == id) {
                    remove = employee;
                    break;
                }
            }
            if (remove != null) {
                employeeList.remove(remove);
            }
        }

        // Displaying all employees
        public void displayEmployees() {
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }

    public static void main(String[] args) {
        // Creating an outer class instance
        PayRole obj = new PayRole();

        // Creating an instance of Payrolee using the outer class object
        PayRole.Payrolee payroll = obj.new Payrolee();

        // Creating employee instances
        PayRole.Fulltime emp1 = obj.new Fulltime("Chaitanya", 1, 60000.00);
        PayRole.PartEmployee emp2 = obj.new PartEmployee("Sanjana", 2, 20, 500.00);

        // Adding employees to payroll
        payroll.addEmployee(emp1);
        payroll.addEmployee(emp2);

        // Displaying employees
        payroll.displayEmployees();

        // Removing an employee and displaying updated list
        payroll.removeEmployee(2);
        System.out.println("\nAfter Removing Employee:");
        payroll.displayEmployees();
    }
}

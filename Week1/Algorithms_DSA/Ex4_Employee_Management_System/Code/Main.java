package ems;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(10);

        system.addEmployee(new Employee("E001", "Ravi Sharma", "Manager", 75000));
        system.addEmployee(new Employee("E002", "Anjali Mehta", "Developer", 60000));
        system.addEmployee(new Employee("E003", "Vikram Singh", "Designer", 50000));

        System.out.println("All Employees:");
        system.traverseEmployees();

        System.out.println("\nSearch Result:");
        Employee result = system.searchEmployee("E002");
        if (result != null) {
            System.out.println(result);
        }

        system.deleteEmployee("E003");
        System.out.println("\nAfter Deletion:");
        system.traverseEmployees();
    }
}


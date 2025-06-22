package ems;

public class EmployeeManagementSystem {
	private Employee[] employees;
	private int count;

	public EmployeeManagementSystem(int capacity) {
		employees = new Employee[capacity];
		count = 0;
	}

	public void addEmployee(Employee employee) {
		if (count < employees.length) {
			employees[count++] = employee;
		}
	}

	public Employee searchEmployee(String employeeId) {
		for (int i = 0; i < count; i++) {
			if (employees[i].getEmployeeId().equals(employeeId)) {
				return employees[i];
			}
		}
		return null;
	}

	public void traverseEmployees() {
		for (int i = 0; i < count; i++) {
			System.out.println(employees[i]);
		}
	}

	public boolean deleteEmployee(String employeeId) {
		for (int i = 0; i < count; i++) {
			if (employees[i].getEmployeeId().equals(employeeId)) {
				for (int j = i; j < count - 1; j++) {
					employees[j] = employees[j + 1];
				}
				employees[--count] = null;
				return true;
			}
		}
		return false;
	}
}

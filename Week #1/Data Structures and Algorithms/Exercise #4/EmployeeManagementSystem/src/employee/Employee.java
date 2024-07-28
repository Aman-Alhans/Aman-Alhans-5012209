package employee;

public class Employee {
	private String employeeId;
	private String name;
	private String position;
	private int Salary;
	
	public Employee(String employeeId,String name, String position, int Salary) {
		this.employeeId = employeeId;
		this.name = name;
		this.position = position; 
		this.Salary = Salary;
	}
	
	public String getemployeeId() {
		return employeeId;
	}
	
	public String getname() {
		return name;
	}
	
	public String getposition() {
		return position;
	}
	
	public int getSalary() {
		return Salary;
	}
	
	@Override
	public String toString() {
		return "Employee Id = " + employeeId + " Name = " + name + " Position = " + position + " Salary = " + Salary;
	}
}

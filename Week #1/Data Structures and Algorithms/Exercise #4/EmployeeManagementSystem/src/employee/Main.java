package employee;
import java.util.Arrays;

public class Main {
	private Employee[] employees;
	private int size;
	
	public Main(int capacity) {
		employees = new Employee[capacity];
		size = 0;
	}
	
	public void add(Employee emp) {
		if(size >= employees.length) {
			employees = Arrays.copyOf(employees , employees.length * 2);
		}
		employees[size++] = emp;
	}
	
	public Employee search(String Id) {
		for (int i=0;i<size;i++) {
			if(employees[i].getemployeeId().equals(Id)) {
				return employees[i];
			}
		}
		
		return null;
	}
	
	public void traverse() {
		for(int i=0;i<size;i++) {
			System.out.println(employees[i]);
		}
	}
	
	public void delete(String Id) {
		for(int i=0;i<size;i++) {
			if(employees[i].getemployeeId().equals(Id)) {
				for(int j=i;j<size - 1;j++) {
					employees[j] = employees[j+1];
				}
				employees[--size] = null;
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Main ems = new Main(5);
		
		ems.add(new Employee("E1","Amit","Manager",10000));
		ems.add(new Employee("E2","Rahul","Developer",20000));
		ems.add(new Employee("E3","Varun","HR",15000));
		ems.add(new Employee("E4","Virat","Developer",25000));
		
		System.out.println("Searching Employee:");
		System.out.println(ems.search("E3"));
		
		System.out.println("\nDeleting Employee:");
		ems.delete("E3");
		
		System.out.println("\nTraversal of All Employees:");
		ems.traverse();
		
	}
}

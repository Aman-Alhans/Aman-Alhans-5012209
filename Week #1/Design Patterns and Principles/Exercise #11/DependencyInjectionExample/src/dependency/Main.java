package dependency;

public class Main {
	public static void main(String[] args) {
		CustomerRepository repository = new CustomerRepositoryImpl();
		
		CustomerService service = new CustomerService(repository);
		
		Customer customer = service.getCustomerById("111");
		System.out.println("Customer Id: " + customer.getId());
		System.out.println("Customer Name: " + customer.getName());
	}
}

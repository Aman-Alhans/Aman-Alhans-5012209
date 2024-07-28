package dependency;

public class CustomerService {
	private final CustomerRepository repo;
	
	public CustomerService(CustomerRepository repo) {
		this.repo = repo;
	}
	
	public Customer getCustomerById(String id) {
		return repo.findCustomerById(id);
	}
}

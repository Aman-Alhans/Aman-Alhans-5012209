package IMS;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
	private Map<String,Product> products = new HashMap<>();
	
	public void add(Product product) {
		products.put(product.getproductId(), product);
	}
	
	public void update (Product product) {
		products.put(product.getproductId(), product);
	}
	
	public void remove(String productId) {
		products.remove(productId);
	}
	
	public Product get(String productId) {
		return products.get(productId);
	}
	
}

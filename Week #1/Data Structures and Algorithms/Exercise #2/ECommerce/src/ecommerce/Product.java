package ecommerce;

public class Product {
	private String productId;
	private String productName;
	private String category;
	
	public Product(String productId, String productName, String category) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
	}
	
	public String getproductId() {
		return productId;
	}
	
	public String getproductName() {
		return productName;
	}
	
	public String getcategory() {
		return category;
	}
	
	@Override
	public String toString() {
		return "Product Id= " + productId + " Product Name= " + productName + " Category= " + category ;
	}
}

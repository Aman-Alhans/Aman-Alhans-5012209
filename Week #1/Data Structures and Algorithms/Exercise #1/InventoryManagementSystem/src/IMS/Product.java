package IMS;

public class Product {
	private String productId;
	private String productName;
	private int quantity;
	private int price;
	
	public Product(String productId, String productName, int quantity, int price) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	public String getproductId() {
		return productId;
	}
	 
	public void setproductId(String productId) {
		this.productId = productId;
	}
	 
	public String getproductName() {
		return productName;
	}
	
	public void setproductName(String productName) {
		this.productName = productName;
	}
	
	public int getquantity() {
		return quantity;
	}
	
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getprice() {
		return price;
	}
	
	public void setprice(int price) {
		this.price = price;
	}
}

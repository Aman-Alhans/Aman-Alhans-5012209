package sorting;

public class Order {
	private String orderId;
	private String customerName;
	private int totalPrice;
	
	public Order(String orderId, String customerName, int totalPrice) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.totalPrice = totalPrice;
	}
	
	public String getorderId() {
		return orderId;
	}
	
	public String getcustomerName() {
		return customerName;
	}
	
	public int gettotalPrice() {
		return totalPrice;
	}
	
	@Override
	public String toString() {
		return "Order Id = " + orderId + " Customer Name = " + customerName + " Total Price = " + totalPrice ;
	}
}

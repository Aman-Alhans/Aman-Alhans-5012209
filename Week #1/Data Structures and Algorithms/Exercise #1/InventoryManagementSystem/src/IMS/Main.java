package IMS;

public class Main {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		
		Product p1 = new Product("P1","Apple",20,100);
		Product p2 = new Product("P2", "Banana",16,150);
		
		inventory.add(p1);
		inventory.add(p2);
		
		Product prod = inventory.get("P1");
		
		System.out.println("Product ID: " + prod.getproductId());
		System.out.println("Product Name: " + prod.getproductName());
		System.out.println("Product Quantity: " + prod.getquantity());
		System.out.println("Product Price: " + prod.getprice());
		
	}
}



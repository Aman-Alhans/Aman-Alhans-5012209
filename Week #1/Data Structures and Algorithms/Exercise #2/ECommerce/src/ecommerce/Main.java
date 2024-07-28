package ecommerce;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Product[] products = {new Product("P1","Phone","Electronics"),
								new Product("P2","Apple","Grocery"),
								new Product("P3","Pencil","Stationary")};
		
		Product p1 = LinearSearch.linearSearch(products,"P2");
		System.out.println("Linear Search : " + (p1 != null ? p1 : "Product not found"));
		
		Product p2 = BinarySearch.binarysearch(products,"P3");
		System.out.println("Binary Search : " + (p2 != null ? p2 : "Product not found"));
	}	
}

class LinearSearch{
	public static Product linearSearch(Product[] products, String productId) {
		for(Product product : products) {
			if(product.getproductId().equals(productId)){
				return product;
			}
		}
		return null;
	}
}

class BinarySearch{
	public static Product binarysearch(Product[] products, String productId) {
		Arrays.sort(products,Comparator.comparing(Product::getproductId));
		int left = 0, right = products.length - 1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			int temp = products[mid].getproductId().compareTo(productId);
			
			if (temp==0) {
				return products[mid];
			}
			else if(temp<0) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return null;
	}
}

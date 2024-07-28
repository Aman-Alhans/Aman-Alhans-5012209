package sorting;

public class Main {
	public static void main(String[] args) {
		Order[] ordersBubble = {new Order("O1","Amit",2300),
							new Order("O2","Rahul",1500),
							new Order("O3","Varun",4370),
							new Order("O4","Virat",1625)};
		
		BubbleSort.bubbleSort(ordersBubble);
		System.out.println("BUBBLE SORT: ");
		for(Order order: ordersBubble) {
			System.out.println(order);
		}
		
		Order[] ordersQuick = {new Order("O1","Amit",2300),
				new Order("O2","Rahul",1500),
				new Order("O3","Varun",4370),
				new Order("O4","Virat",1625)};
		
		QuickSort.quickSort(ordersQuick, 0, ordersQuick.length - 1);
		System.out.println("QUICK SORT: ");
		for (Order order: ordersQuick) {
			System.out.println(order);
		}
	}
}

class BubbleSort {
	public static void bubbleSort(Order[] orders) {
		for(int i=0;i<orders.length - 1;i++) {
			for(int j =0;j <orders.length - 1 - i;j++) {
				if(orders[j].gettotalPrice() > orders[j+1].gettotalPrice()) {
					Order temp = orders[j];
					orders[j] = orders[j+1];
					orders[j+1] = temp;
				}
			}
		}
	}
}

class QuickSort {
	public static void quickSort(Order[] orders, int low, int high) {
		if(low<high) {
			int pi = partition(orders,low,high);
			
			quickSort(orders,low,pi-1);
			quickSort(orders,pi+1,high);
		}
	}
	
	private static int partition(Order[] orders, int l, int h) {
		int pivot =  orders[h].gettotalPrice();
		int i = l - 1;
		
		for(int j=l;j<h;j++) {
			if(orders[j].gettotalPrice() < pivot) {
				i++;
				
				Order temp = orders[i];
				orders[i] = orders[j];
				orders[j] = temp;
			}
		}
		
		Order temp = orders[i+1];
		orders[i+1] = orders[h];;
		orders [h] = temp;
		
		return i+1;
	}
}


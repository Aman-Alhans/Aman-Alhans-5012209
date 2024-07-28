package adapter;

public class Main {
	public static void main(String[] args) {
		Paytm paytm = new Paytm();
		GooglePay googlepay = new GooglePay();
		
		PaymentProcessor PaytmAdapter = new PaytmAdapter(paytm);
		PaymentProcessor GooglePayAdapter = new GooglePayAdapter(googlepay);
		
		System.out.println("Using Paytm:");
		PaytmAdapter.processPayment(10000);
		
		System.out.println("Using GooglePay:");
		GooglePayAdapter.processPayment(146);
		
	}
}

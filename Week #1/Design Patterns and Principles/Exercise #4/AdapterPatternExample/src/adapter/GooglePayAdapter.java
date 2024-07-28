package adapter;

public class GooglePayAdapter implements PaymentProcessor {
	public GooglePay googlepay;
	
	public GooglePayAdapter(GooglePay googlepay) {
		this.googlepay = googlepay;
	}
	
	@Override
	public void processPayment(int amount) {
		googlepay.payment(amount);
	}
	

}

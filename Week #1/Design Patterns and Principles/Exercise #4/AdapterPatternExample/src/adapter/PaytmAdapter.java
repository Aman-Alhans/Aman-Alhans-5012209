package adapter;

public class PaytmAdapter implements PaymentProcessor {
	private Paytm paytm;
	
	public PaytmAdapter(Paytm paytm) {
		this.paytm=paytm;
	}
	
	@Override
	public void processPayment(int amount) {
		paytm.payment(amount);
	}
	

}

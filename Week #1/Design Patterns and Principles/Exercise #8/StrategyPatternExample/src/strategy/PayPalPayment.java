package strategy;

public class PayPalPayment implements PaymentStrategy{
	private String name;
	private String UPI;
	
	public PayPalPayment(String name, String UPI) {
		this.name = name;
		this.UPI = UPI;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println("Amount paid is " + amount + " by " + name);
	}
}

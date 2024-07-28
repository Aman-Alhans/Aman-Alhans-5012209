package strategy;

public class CreditCardPayment implements PaymentStrategy{
	private String CardNumber;
	private String cvv;
	
	public CreditCardPayment(String CardNumber,String cvv) {
		this.CardNumber = CardNumber;
		this.cvv = cvv;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println("Amount paid is " + amount + " having Card Number " + CardNumber);
	}
}

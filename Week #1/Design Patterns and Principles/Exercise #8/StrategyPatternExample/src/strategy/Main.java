package strategy;

public class Main {
	public static void main(String[] args) {
		PaymentContext context = new PaymentContext();
		
		PaymentStrategy creditCard = new CreditCardPayment("123-234-345-456","321");
		context.setStrategy(creditCard);
		context.pay(2500);
		
		PaymentStrategy payPal = new PayPalPayment("Amit","Amit@PayPal");
		context.setStrategy(payPal);
		context.pay(1200);
	}
}

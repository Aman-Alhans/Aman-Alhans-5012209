package strategy;

public class PaymentContext {
	private PaymentStrategy strategy;
	
	public void setStrategy(PaymentStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void pay(int amount) {
		if (strategy==null) {
			System.out.println("Select Payment Method!");
		}
		else {
			strategy.pay(amount);
		}
	}
}

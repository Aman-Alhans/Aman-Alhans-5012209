package observer;

public class MobileApp implements Observer{
	private String name;
	
	public MobileApp(String name) {
		this.name = name;
	}
	
	@Override
	public void update(int stockPrice) {
		System.out.println(name + " got stock price update: Rs. " + stockPrice);
	}
}

package observer;

public class WebApp implements Observer{
	private String name;
	
	public WebApp(String name) {
		this.name = name;
	}
	
	@Override
	public void update(int stockPrice) {
		System.out.println(name + " got stock price update: Rs. " + stockPrice);
	}

}

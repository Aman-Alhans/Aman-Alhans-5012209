package observer;

public class Main {
	public static void main(String[] args) {
		StockMarket sm=new StockMarket();
		
		Observer mobapp = new MobileApp("App1");
		Observer webapp = new WebApp("App2");
		
		sm.register(mobapp);
		sm.register(webapp);
		
		sm.setStockPrice(24);
		sm.setStockPrice(312);
		
		sm.deregister(mobapp);
		sm.setStockPrice(231);
		
	}
}

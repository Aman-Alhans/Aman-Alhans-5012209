package financial;

public class Main {
	public double predict(int initial, double growth, int time) {
		if(time == 0) return initial;
		
		return (1.0 + growth) * predict(initial,growth,time - 1);
	}
	
	public static void main(String[] args) {
		Main finance = new Main();
		
		int intital = 15000; // Initial Value invested
		double growth = 0.10; // Growth rate 10%
		int time = 5; // Number of years
		
		double value = finance.predict(intital, growth, time);
		System.out.println("Forecasted Value is : " + value);
	}
}
public class Logger {
	public static Logger instance;
	
	private Logger() {
		//code to initialize
	}
	
	public static Logger getInstance() {
		if(instance==null) {
		instance = new Logger();
		}
		return instance;
	}
	
	public void log(String message) {
		System.out.println("Message : " + message);
	}

}

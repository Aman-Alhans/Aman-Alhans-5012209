
public class Main {
	public static void main(String[] args) {
		Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("This is the first log message.");
        l2.log("This is the second log message.");

        System.out.println("Logger 1 instance: " + l1);
        System.out.println("Logger 2 instance: " + l2);

        if (l1 == l2) {
            System.out.println("Both logger instances are the same.");
        } else {
            System.out.println("Logger instances are different.");
        }
	}
}

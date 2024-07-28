package proxy;

public class Main {
	public static void main(String[] args) {
		Image image = new ProxyImage("photo.jpg");
		
		System.out.println("Displaying after loading from remote server:");
		image.display();
		
		System.out.println("Displaying after loading from remote server, only displayed from cache:");
		image.display();
	}
}

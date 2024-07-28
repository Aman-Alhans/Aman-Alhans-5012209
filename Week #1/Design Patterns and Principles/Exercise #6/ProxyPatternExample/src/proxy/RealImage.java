package proxy;

public class RealImage implements Image {
	
	private String fileName;
	
	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromRemoteServer();
	}
	
	
	private void loadFromRemoteServer() {
		System.out.println("Loading " + fileName + " from remote server ....");
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	@Override
	public void display() {
		System.out.println("Displaying: " 	+ fileName);
	}
}

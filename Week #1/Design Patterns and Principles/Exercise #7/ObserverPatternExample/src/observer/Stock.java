package observer;

public interface Stock {
	void register(Observer observer);
	void deregister(Observer observer);
	void notifyObserver();
	
}

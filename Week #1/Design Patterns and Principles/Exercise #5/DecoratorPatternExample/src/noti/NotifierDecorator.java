package noti;
public abstract class NotifierDecorator implements Notifier{
	protected Notifier notifier;
	public NotifierDecorator(Notifier notifier) {
		this.notifier=notifier;
	}
	
	@Override
	public void send(){
		notifier.send();
	}
}

package noti;
public class SMSNotifierDecorator extends NotifierDecorator {
	public SMSNotifierDecorator(Notifier notifier) {
		super(notifier);
	}
	
	@Override
	public void send() {
		super.send();
		sendSMS();
	}
	
	private void sendSMS() {
		System.out.println("Sending SMS notification.");
	}
}

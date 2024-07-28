package noti;
public class SlackNotifierDecorator extends NotifierDecorator {
	public SlackNotifierDecorator(Notifier notifier) {
		super(notifier);
	}
	
	@Override
	public void send() {
		super.send();
		sendSlackMessage();
	}
	
	private void sendSlackMessage() {
		System.out.println("Sending Slack notification.");
	}
}

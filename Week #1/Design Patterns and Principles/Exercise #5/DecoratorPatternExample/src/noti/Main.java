package noti;

public class Main {
	public static void main(String[] args) {
		Notifier emailNotifier=new EmailNotifier();
		
		Notifier smsNotifier=new SMSNotifierDecorator(emailNotifier);
		smsNotifier.send();
		System.out.println();
		
		Notifier slackNotifier=new SlackNotifierDecorator(emailNotifier);
		slackNotifier.send();
		System.out.println();
		
		Notifier smsAndSlackNotifier=new SMSNotifierDecorator(new SlackNotifierDecorator(emailNotifier));
		smsAndSlackNotifier.send();
	}
}

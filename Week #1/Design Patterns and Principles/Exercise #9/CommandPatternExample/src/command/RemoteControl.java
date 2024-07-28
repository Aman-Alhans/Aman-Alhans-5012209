package command;

public class RemoteControl {
	private Command command;
	
	public void set(Command command) {
		this.command = command;
	}
	
	public void PressButton() {
		command.execute();
	}
}

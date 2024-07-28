package command;

public class Main {
	public static void main(String[] args) {
		Light Room = new Light();
		Command On = new LightOnCommand(Room);
		Command Off = new LightOffCommand(Room);
		
		RemoteControl Control = new RemoteControl();
		
		Control.set(On);
		Control.PressButton();
		
		Control.set(Off);
		Control.PressButton();
	}
}

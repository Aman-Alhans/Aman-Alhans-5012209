package builder;

public class Main {
	public static void main(String[] args) {
		Computer basicComputer = new Computer.Builder()
				.setCPU("Intel i5")
				.setRAM("8GB")
				.setStorage("256GB SSD")
				.build();
		System.out.println("Basic Computer: " + basicComputer);
		
		Computer gamingComputer = new Computer.Builder()
				.setCPU("Intel i9")
				.setRAM("16GB")
				.setStorage("1TB SSD")
				.build();
		System.out.println("Gaming Computer: " + gamingComputer);
	}
}

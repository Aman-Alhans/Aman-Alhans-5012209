package builder;

public class Computer {
	public final String CPU;
	public final String RAM;
	public final String storage;
	
	private Computer(Builder builder) {
		this.CPU = builder.CPU;
		this.RAM = builder.RAM;
		this.storage = builder.storage;
	}
	
	@Override
	public String toString() {
		return "Computer{" + "CPU='" + CPU +'\'' + "RAM='" + RAM + '\'' + "Storage='" + storage + '\''+'}'; 
	}
	
	public static class Builder{
		public String CPU;
		public String RAM;
		public String storage;
		
		public Builder setCPU(String CPU) {
			this.CPU = CPU;
			return this;
		}
		
		public Builder setRAM(String RAM) {
			this.RAM = RAM;
			return this;
		}
		
		public Builder setStorage(String storage) {
			this.storage=storage;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
		
	}
	
	
}

public class ThreadMain {
	
	public static void main(String[] args) {

		String name = "Karan";
		DataStorage dataWarehouse = new DataStorage(name);
		Creator create = new Creator(dataWarehouse);
		Printer print = new Printer(dataWarehouse);

		
		Thread t1= new Thread(create);
		t1.start();
		Thread t2= new Thread(print);
		t2.start();
	
	}
}

public class Printer implements Runnable {
	DataStorage dataStorage;

	public Printer(DataStorage dataStorage) {
		this.dataStorage = dataStorage;
	}

	public void run() {
		for (int i = 0; i < dataStorage.getName().length(); i++) {
			dataStorage.getData();
		}
		System.out.println("Bye.");
	}
}

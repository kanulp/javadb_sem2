public class Printer implements Runnable {
	DataStorage dtaWarehouse;

	public Printer(DataStorage d) {
		this.dtaWarehouse = d;
	}

	public void run() {
		for (int i = 0; i < 9; i++) {
			dtaWarehouse.getData();
		}
	}
}

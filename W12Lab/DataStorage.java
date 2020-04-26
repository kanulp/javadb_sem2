import java.util.ArrayList;

public class DataStorage {

	private ArrayList<Character> dataWarehouse = new ArrayList<Character>();

	public synchronized void getData() {
		while (dataWarehouse.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Print : " + "   " + dataWarehouse.get(0));
		System.out.println(" ");
		dataWarehouse.remove(0);

		// return dataWarehouse;

	}

	public synchronized void addData(char a) {
		dataWarehouse.add(a);
		System.out.println("Sent :" + "   " + a);
		System.out.println("Warehouse :"+"  "+a);
		notifyAll();
	}

	public static void main(String[] args) {

		DataStorage dataWarehouse = new DataStorage();
		Creator create = new Creator(dataWarehouse);
		Printer print = new Printer(dataWarehouse);

		Thread t1= new Thread(create);
		t1.start();
		Thread t2= new Thread(print);
		t2.start();
		
		/*
		 * try { 
		 * t1.join();
		 * t2.join(); 
		 * } catch (InterruptedException e) { 
		 * block e.printStackTrace();
		 *  }
		 */
	}

}

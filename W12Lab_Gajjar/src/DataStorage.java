import java.util.ArrayList;

public class DataStorage {

	private String name;
	private ArrayList<Character> dataWarehouselist = new ArrayList<Character>();

	DataStorage(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	//being called by print thread
	public synchronized void getData() {
		while (dataWarehouselist.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Print : " + "   " + dataWarehouselist.get(0));
		dataWarehouselist.remove(0);

	}

	//being called by create thread notify will call 
	public synchronized void addData(char a) {
		dataWarehouselist.add(a);
		System.out.println("Warehouse :"+"  "+a);
		notifyAll();
	}

	

}

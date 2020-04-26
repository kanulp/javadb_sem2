public class PrintThread implements Runnable {

	PrintThread(){
		
	}
	
	@Override
	public void run() {
		
		DataStorage d = new DataStorage();
		System.out.println("Print :"+d.getCharactor());
		
	}

}

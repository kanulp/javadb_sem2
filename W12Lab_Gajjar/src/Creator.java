public class Creator implements Runnable{

	DataStorage dataStorage;
	public Creator(DataStorage dataStorage) {
		this.dataStorage = dataStorage;
	}
	
	 public void run() {
		 
		 char[] a = new char[dataStorage.getName().length()];
		 a = dataStorage.getName().toCharArray();
		  
		 for(int i=0; i<dataStorage.getName().length() ; i++) {
			System.out.println("Sent :" + "   " + a[i]);
			 dataStorage.addData(a[i]);
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	 
		 }
	 }
	 
}

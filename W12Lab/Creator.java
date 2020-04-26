public class Creator implements Runnable{

	DataStorage dw;
	public Creator(DataStorage d) {
		this.dw = d;
	}
	
	 public void run() {
		 String name = "gurmanjot";
		 
		 char[] a = new char[9];
		 a = name.toCharArray();
		  
		 for(int i=0; i<9 ; i++) {
			 dw.addData(a[i]);
			 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 
		 }
		 
		 
		 
	 }
	 
}

public class MultiThreadDemo {

	public static void main(String[] args) {
		
		String name = "KARAN";
		
		
		CreatorThread create = new CreatorThread();
		PrintThread print = new PrintThread();	
		Thread t1 = new Thread(create);
		Thread t2 = new Thread(print);
		
		for (int i = 0; i < name.length(); i++) {
			
			create = new CreatorThread(name.charAt(i));
			print = new PrintThread();	
			
			
			t1.run();
			t2.run();
		}
		
	}

}

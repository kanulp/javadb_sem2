
public class CreatorThread implements Runnable {

	char c;
	
	CreatorThread(){}
	
	CreatorThread(char c){
		this.c=c;
	}

	@Override
	public void run() {
		System.out.println("Sent "+c);
		new DataStorage(c);

	}
}

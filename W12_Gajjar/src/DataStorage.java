
public class DataStorage {

	private char c;
	
	DataStorage(){
		
	}
	
	DataStorage(char c){
		this.setCharactor(c);
		System.out.println("Warehouse : "+c);
	}

	public char getCharactor() {
		return c;
	}

	public void setCharactor(char c) {
		this.c = c;
	}
	
	
}

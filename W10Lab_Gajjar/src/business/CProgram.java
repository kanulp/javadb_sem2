package business;

public class CProgram {
	
	private String pID,pName;
	private String pSeats,pSemesters;
	
	public String getpID() {
		return pID;
	}
	public void setpID(String pID) {
		this.pID=pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName=pName;
	}
	public String getpSeats() {
		return pSeats;
	}
	public void setpSeats(String pSeats) {
		this.pSeats=pSeats;
	}
	public String getpSemesters() {
		return pSemesters;
	}
	public void setpSemesters(String pSemesters) {
		this.pSemesters=pSemesters;
	}
	public CProgram(String pID, String pName, String pSeats, String pSemesters) {
		this.pID=pID;
		this.pName=pName;
		this.pSeats=pSeats;
		this.pSemesters=pSemesters;
	}
	public CProgram() {
		
	}
	@Override
	public String toString() {
		return pName + "[ " +pID+ " ] ,"+pSemesters+","+pSeats;
	}
}

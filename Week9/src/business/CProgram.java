package business;

public class CProgram {
	private String pID,pName;
	private int pSeats, pSemesters;
	
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
	public int getpSeats() {
		return pSeats;
	}
	public void setpSeats(int pSeats) {
		this.pSeats=pSeats;
	}
	public int getpSemesters() {
		return pSemesters;
	}
	public void setpSemesters(int pSemesters) {
		this.pSemesters=pSemesters;
	}
	public CProgram() {}
	public CProgram(String pID, String pName,int pSeats, int pSemesters) {
		this.pID=pID;
		this.pName=pName;
		this.pSeats=pSeats;
		this.pSemesters=pSemesters;
	}
}

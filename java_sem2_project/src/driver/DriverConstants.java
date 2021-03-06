package driver;

public interface DriverConstants {

	String FILENAME_TEXT="driver.txt";
	String FILENAME_BIN="driver.dat";
	String FILENAME_BIN_FIXED="driverFixed.dat";
	
	String FIELD_SEP="\t";
	
	int FIRST_NAME_SIZE=25;
	int LAST_NAME_SIZE=25;
	int AGE_SIZE=4;
	
	int GENDER_SIZE=6;
	
    int RECORD_SIZE=FIRST_NAME_SIZE*2+LAST_NAME_SIZE*2+AGE_SIZE+5*FIRST_NAME_SIZE;

}

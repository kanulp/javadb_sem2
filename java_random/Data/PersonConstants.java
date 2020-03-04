package Data;

public interface PersonConstants {
	
	String FILENAME_TEXT="persons.txt";
	String FILENAME_BIN="persons.dat";
	String FILENAME_BIN_FIXED="personFixed.dat";
	
	String FIELD_SEP="\t";
	
	int FIRST_NAME_SIZE=25;
	int LAST_NAME_SIZE=25;
	int AGE_SIZE=4;
	int GENDER_SIZE=6;
	
    int RECORD_SIZE=FIRST_NAME_SIZE*2+LAST_NAME_SIZE*2+AGE_SIZE+GENDER_SIZE*2;
}

package Data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import Business.Person;

public class PersonDAORandom implements PersonDAO {

	private int count;
	private File personFile = null;
	private RandomAccessFile dataFile = null;

	public PersonDAORandom() {
		personFile = new File(PersonConstants.FILENAME_BIN_FIXED);
	}

	@Override
	public Person getPerson(String firstName) {
		int i = Integer.parseInt(firstName);
	
		try {
			dataFile = new RandomAccessFile(personFile, "rw");
			count = (int) dataFile.length()/PersonConstants.RECORD_SIZE;
			if (i <= count) {
				dataFile.seek((i - 1) * PersonConstants.RECORD_SIZE);
				Person person = new Person();
				person.setFirstName(readString(dataFile, PersonConstants.FIRST_NAME_SIZE));
				person.setLastName(readString(dataFile, PersonConstants.LAST_NAME_SIZE));
				person.setGender(readString(dataFile, PersonConstants.GENDER_SIZE));
				person.setAge(dataFile.readInt());
				return person;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dataFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public ArrayList<Person> getPersons() {
		ArrayList<Person> persons = new ArrayList<Person>();
		try {
			dataFile = new RandomAccessFile(personFile, "rw");
			count = (int) dataFile.length() / PersonConstants.RECORD_SIZE;
			for (int i = 0; i < count; i++) {
				dataFile.seek(i * PersonConstants.RECORD_SIZE);
				Person person = new Person();
				person.setFirstName(readString(dataFile, PersonConstants.FIRST_NAME_SIZE));
				person.setLastName(readString(dataFile, PersonConstants.LAST_NAME_SIZE));
				person.setGender(readString(dataFile, PersonConstants.GENDER_SIZE));
				person.setAge(dataFile.readInt());
				persons.add(person);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dataFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return persons;
	}

	private String readString(DataInput in, int length) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = in.readChar();
			if (c != 0)
				sb.append(c);
		}

		return sb.toString();
	}

	@Override
	public boolean addPerson(Person person) {
		boolean success = false;
		try {
			dataFile = new RandomAccessFile(personFile, "rw");
			count = (int) dataFile.length() / PersonConstants.RECORD_SIZE;
			dataFile.seek(count * PersonConstants.RECORD_SIZE);
			writeString(dataFile, PersonConstants.FIRST_NAME_SIZE, person.getFirstName());
			writeString(dataFile, PersonConstants.LAST_NAME_SIZE, person.getLastName());
			writeString(dataFile, PersonConstants.GENDER_SIZE, person.getGender());
			dataFile.writeInt(person.getAge());
			success = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dataFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return success;
	}

	private void writeString(DataOutput out, int length, String s) throws IOException {
		for (int i = 0; i < length; i++) {
			if (i < s.length())
				out.writeChar(s.charAt(i));
			else
				out.writeChar(0);
		}

	}

}

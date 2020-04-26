package driver;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import business.Driver;

public class DriverDAORandom implements DriverDAO {

	private int count;
	private File driverFile = null;
	private RandomAccessFile dataFile = null;

	public DriverDAORandom() {
		driverFile = new File(DriverConstants.FILENAME_BIN_FIXED);
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

	private void writeString(DataOutput out, int length, String s) throws IOException {
		for (int i = 0; i < length; i++) {
			if (i < s.length())
				out.writeChar(s.charAt(i));
			else
				out.writeChar(0);
		}

	}

	@Override
	public Driver getDriver(String firstName) {
		int i = Integer.parseInt(firstName);
		
		try {
			dataFile = new RandomAccessFile(driverFile, "rw");
			count = (int) dataFile.length()/DriverConstants.RECORD_SIZE;
			if (i <= count) {
				dataFile.seek((i - 1) * DriverConstants.RECORD_SIZE);
				Driver driver = new Driver();
				driver.setUserName(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setPassword(readString(dataFile, DriverConstants.LAST_NAME_SIZE));
				driver.setEmail(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setAge(dataFile.readInt());
				driver.setAddress(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setLicenseNumber(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setCarModel(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setCarNumberPlate(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setExperience(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				return driver;
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
	public ArrayList<Driver> getDrivers() {
		ArrayList<Driver> persons = new ArrayList<Driver>();
		try {
			dataFile = new RandomAccessFile(driverFile, "rw");
			count = (int) dataFile.length() / DriverConstants.RECORD_SIZE;
			for (int i = 0; i < count; i++) {
				dataFile.seek(i * DriverConstants.RECORD_SIZE);
				Driver driver = new Driver();
				driver.setUserName(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setPassword(readString(dataFile, DriverConstants.LAST_NAME_SIZE));
				driver.setEmail(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setAge(dataFile.readInt());
				driver.setAddress(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setLicenseNumber(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setCarModel(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setCarNumberPlate(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				driver.setExperience(readString(dataFile, DriverConstants.FIRST_NAME_SIZE));
				persons.add(driver);
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

	@Override
	public boolean addDriver(Driver driver) {
		boolean success = false;
		try {
			dataFile = new RandomAccessFile(driverFile, "rw");
			count = (int) dataFile.length() / DriverConstants.RECORD_SIZE;
			dataFile.seek(count * DriverConstants.RECORD_SIZE);
			writeString(dataFile, DriverConstants.FIRST_NAME_SIZE, driver.getUserName());
			writeString(dataFile, DriverConstants.LAST_NAME_SIZE, driver.getPassword());
			writeString(dataFile, DriverConstants.LAST_NAME_SIZE, driver.getEmail());
			writeString(dataFile, DriverConstants.LAST_NAME_SIZE, driver.getPhoneNumber());
			dataFile.writeInt(driver.getAge());
			writeString(dataFile, DriverConstants.LAST_NAME_SIZE, driver.getAddress());
			writeString(dataFile, DriverConstants.LAST_NAME_SIZE, driver.getLicenseNumber());
			writeString(dataFile, DriverConstants.LAST_NAME_SIZE, driver.getCarModel());
			writeString(dataFile, DriverConstants.LAST_NAME_SIZE, driver.getCarNumberPlate());
			writeString(dataFile, DriverConstants.LAST_NAME_SIZE, driver.getExperience());

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

}

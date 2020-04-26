package data;

import driver.DriverDAO;
import driver.DriverDAORandom;
import person.PersonDAO;
import person.PersonDAORandom;

public class DAOFactory {
public static PersonDAO getPersonDAO() {
	PersonDAO pDAO=new PersonDAORandom();
	return pDAO;
}
public static DriverDAO getDriverDAO() {
	DriverDAO pDAO=new DriverDAORandom();
	return pDAO;
}
}

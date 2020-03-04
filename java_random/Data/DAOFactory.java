package Data;

public class DAOFactory {
public static PersonDAO getPersonDAO() {
	PersonDAO pDAO=new PersonDAORandom();
	return pDAO;
}
}

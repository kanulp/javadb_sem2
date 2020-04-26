package data;

public class DAOFactory {

    public static PersonDAO getPersonDAO(){
        PersonDAO pDao = new PersonDAOText();
        //PersonDAO pDao = new PersonDAOBinary();
        return pDao;
    }
}
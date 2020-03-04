package Data;

import java.util.*;

public interface  PersonReader 
{
	Business.Person getPerson(String firstName);
	ArrayList<Business.Person> getPersons();

}

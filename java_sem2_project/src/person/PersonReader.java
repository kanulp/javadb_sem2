package person;

import java.util.*;

public interface  PersonReader 
{
	business.Person getPerson(String firstName);
	ArrayList<business.Person> getPersons();
	
}

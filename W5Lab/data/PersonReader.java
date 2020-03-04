package data;
import java.util.ArrayList;

import business.Person;

public interface PersonReader {
    Person getPerson(String firstName);
    ArrayList<Person> getPersons();
    
}
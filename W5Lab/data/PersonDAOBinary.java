package data;
import java.io.*;
import java.util.ArrayList;

import business.Person;

public class PersonDAOBinary implements PersonDAO{
    private File personFile = null;

    public PersonDAOBinary(){
        personFile = new File(PersonConstants.FILENAME_BIN);
    }

    @Override
	public Person getPerson(String firstName) {
		ArrayList<Person> persons = this.getPersons();
		for (Person ps : persons) {
			if (ps.getFirstName().equalsIgnoreCase(firstName)) {
				return ps;
			}
		}
		return null;
	}

    private void checkFile() throws IOException {
		if (!personFile.exists()) {
			personFile.createNewFile();
		}
	}
    @Override
    public ArrayList<Person> getPersons(){
        DataInputStream in = null;
        ArrayList<Person> persons = new ArrayList<Person>();
        try{
            this.checkFile();
            in = new DataInputStream(new FileInputStream(personFile));
            String firstName = in.readUTF();
            String lastName = in.readUTF();
            int age = in.readInt();
            boolean gender = in.readBoolean();
            Person p = new Person(firstName,lastName,age,gender);
            p.setAge(age);
            p.setGender(gender);
            persons.add(p);
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return persons;
    }
    @Override
	public boolean addPerson(Person person) {
		ArrayList<Person> persons = this.getPersons();
		persons.add(person);
		return this.savePerson(persons);
	}
    private boolean savePerson(ArrayList<Person> persons) {
		DataOutputStream out = null;
		try {
			this.checkFile();
			out = new DataOutputStream(new FileOutputStream(personFile));
			for (Person p : persons) {
				out.writeUTF(p.getFirstName());
				out.writeUTF(p.getLastName());
				out.writeInt(p.getAge());
				out.writeBoolean(p.getGender());
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			this.close(out);
		}
		return true;
	}
    private void close(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
package data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import business.Person;

public class PersonDAOText implements PersonDAO{
    private File personFile = null;

    public PersonDAOText() {
    	personFile = new File(PersonConstants.FILENAME_TEXT);
	}

    private void checkFile() throws IOException {
		if (!personFile.exists()) {
			personFile.createNewFile();
		}
	}

    private boolean savePerson(ArrayList<Person> persons) {
		PrintWriter out = null;
		try {
			this.checkFile();
			out = new PrintWriter(new BufferedWriter(new FileWriter(personFile)));
			for (Person p : persons) {
				out.print(p.getFirstName() + FIELD_SEP);
				out.print(p.getLastName() + FIELD_SEP);
				out.print(p.getAge()+FIELD_SEP);
				out.println(p.getGender());
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
    
	@Override
	public Person getPerson(String firstName) {
		ArrayList<Person> persons = this.getPersons();
		for (Person p : persons) {
			if (p.getFirstName().equalsIgnoreCase(firstName)) {
				return p;
			}
		}
		return null;
	}
	public Person getPerson() {
		BufferedReader in = null;
		Person p = null;
		try {
			this.checkFile();
			in = new BufferedReader(new FileReader(personFile));
			ArrayList<Person> persons = new ArrayList<Person>();
			String line = in.readLine();
			while (line != null) {
				String[] columns = line.split(FIELD_SEP);
				String firstName = columns[0];
				String lastName = columns[1];
				int age = Integer.parseInt(columns[2]);
				boolean gender = Boolean.parseBoolean(columns[3]);
				p = new Person(firstName,lastName,age,gender );
				persons.add(p);
				line = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public ArrayList<Person> getPersons() {
		BufferedReader in = null;
		ArrayList<Person> persons = new ArrayList<Person>();
		try {
			this.checkFile();
			in = new BufferedReader(new FileReader(personFile));
			String line = in.readLine();
			while (line != null) {
				String[] columns = line.split(FIELD_SEP);
				String firstName = columns[0];
				String lastName = columns[1];
				int age = Integer.parseInt(columns[2]);
				boolean gender = Boolean.parseBoolean(columns[3]);
				Person p = new Person(firstName,lastName,age,gender );
				persons.add(p);
				line = in.readLine();
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
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

}
package Data;

import java.io.*;
import java.util.ArrayList;

import Business.Person;

public class PersonDAOText implements PersonDAO {
	private File personFile = null;

	public PersonDAOText() {
		personFile = new File(PersonConstants.FILENAME_TEXT);
	}

	private void checkFile() throws IOException {
		if (!personFile.exists())
			personFile.createNewFile();
	}

	private boolean savePersons(ArrayList<Person> persons) {
		PrintWriter out = null;
		try {
			this.checkFile();
			out = new PrintWriter(new BufferedWriter(new FileWriter(personFile)));
			for (Person p : persons) {
				out.print(p.getFirstName() + FIELD_SEP);
				out.print(p.getLastName() + FIELD_SEP);
				out.print(p.getGender() + FIELD_SEP);
				out.println(p.getAge());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		} finally {
			this.close(out);
		}
		return true;
	}

	private void close(Closeable stream) {
		try {
			if(stream!=null)
				stream.close();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		
	}

	@Override
	public Person getPerson(String firstName) {
		ArrayList<Person> persons = this.getPersons();
		for (Person p : persons) {
			if (p.getFirstName().equalsIgnoreCase(firstName))
				return p;
		}
		return null;
	}

	@Override
	public ArrayList<Person> getPersons() {

		BufferedReader in = null;
		try {
			this.checkFile();
			in = new BufferedReader(new FileReader(personFile));
			ArrayList<Person> persons = new ArrayList<Person>();
			String line = in.readLine();
			while (line != null) {
				String[] columns = line.split(FIELD_SEP);
				String firstName = columns[0];
				String lastName = columns[1];
				String gender = columns[2];
				int age = Integer.parseInt(columns[3]);
				Person p = new Person(firstName, lastName);
				p.setAge(age);
				p.setGender(gender);
				persons.add(p);
				line = in.readLine();
			}
			return persons;
		}

		catch (IOException io) {
			io.printStackTrace();
			return null;
		} finally {
			this.close(in);
		}

	}

	@Override
	public boolean addPerson(Person person) {

		ArrayList<Person> persons = this.getPersons();
		persons.add(person);
		return this.savePersons(persons);
	}
}

package Business;

public class Person {
	String firstName, lastName, gender;
	int age;
    
	public Person() {
		
	}
	public Person(String firstName1, String lastName1) {

		this.firstName = firstName1;
		this.lastName = lastName1;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {

		this.gender = gender;

	}

	public void setFirstName(String firstName2) {
		// TODO Auto-generated method stub
		firstName=firstName2;
	}

	public void setLastName(String lastName2) {
		
		lastName=lastName2;
		
	}

}

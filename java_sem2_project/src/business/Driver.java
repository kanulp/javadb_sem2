package business;

public class Driver {
	
	private int id;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private int age;
	private String address;
	private String licenseNumber;
	private String carModel;
	private String carNumberPlate;
	private String experience;
	
	public Driver() {
		
	}
	public Driver(String userName,String password,String email,
			String phoneNumber,int age,String address,String 
			licenseNumber,String carModel,String carNumberPlate,String experience){
		this.userName=userName;
		this.password=password;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.age=age;
		this.address=address;
		this.licenseNumber = licenseNumber;
		this.carModel = carModel;
		this.carNumberPlate=carNumberPlate;
		this.experience = experience;
		
	}
	
	public Driver(int id,String userName,String password,String email,
			String phoneNumber,int age,String address,String 
			licenseNumber,String carModel,String carNumberPlate,String experience){
		this.id=id;
		this.userName=userName;
		this.password=password;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.age=age;
		this.address=address;
		this.licenseNumber = licenseNumber;
		this.carModel = carModel;
		this.carNumberPlate=carNumberPlate;
		this.experience = experience;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLicenseNumber() {
		return licenseNumber;
	}


	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	public String getCarModel() {
		return carModel;
	}


	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}


	public String getCarNumberPlate() {
		return carNumberPlate;
	}


	public void setCarNumberPlate(String carNumberPlate) {
		this.carNumberPlate = carNumberPlate;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}
	
}

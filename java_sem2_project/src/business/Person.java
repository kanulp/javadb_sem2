package business;

public class Person {

		private int id;
		private String userName;
		private String password;
		private String email;
		private String phoneNumber;
		private int age;
		private String address;
		private String coupon;
		
		public Person() {
			
		}
		
		public Person(int id, String password, String email, String phoneNumber, int age, String address,
				String coupon) {
			super();
			this.id = id;
			this.password = password;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.age = age;
			this.address = address;
			this.coupon = coupon;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public String getCoupon() {
			return coupon;
		}
		public void setCoupon(String coupon) {
			this.coupon = coupon;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		
		
		
}	

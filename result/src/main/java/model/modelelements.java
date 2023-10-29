package model;

public class modelelements {
	private String name;
	private String Accountno;
	private String mobileno;
	private String email;
	private String gender;
	private String password;
	private String date;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountno() {
		return Accountno;
	}
	public void setAccountno(String accountno) {
		Accountno = accountno;
	}
	
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "modelelements [name=" + name + ", Accountno=" + Accountno + ", mobileno=" + mobileno + ", email="
				+ email + ", gender=" + gender + ", password=" + password + ", date=" + date + ", address=" + address
				+ "]";
	}
	public modelelements(String name, String accountno, String mobileno, String email, String gender, String password,
			String date, String address) {
		super();
		this.name = name;
		Accountno = accountno;
		this.mobileno = mobileno;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.date = date;
		this.address = address;
	}
	
	
	

}

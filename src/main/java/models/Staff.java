package models;

public class Staff {
	
	private String firstName;
	private String lastName;
	private String nickName;
	private int salary;
	private String currency;
	
	
	
	public Staff(String firstName, String lastName, String nickName, int salary, String currency) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.salary = salary;
		this.currency = currency;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	@Override
	public String toString() {
		return "Staff [firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName + ", salary="
				+ salary + ", currency=" + currency + "]";
	}
	
	
	
	
	

}

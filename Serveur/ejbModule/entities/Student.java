package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class Student extends User implements Serializable{
	
	private String firstName;
	private String lastName;
	private String telephone;
	private static final long serialVersionUID = 1L;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Student(String firstName, String lastName, String telephone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", telephone=" + telephone + "]";
	}
	
}

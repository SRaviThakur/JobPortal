package com.galaxe.rst;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Emp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]+" , message="No digits allowed")
	private String firstName;
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]+" , message="No digits allowed")
	private String lastName;
	@NotEmpty
	private String gender;
	@NotEmpty
	@Pattern(regexp = "[0-9]+" , message="Numbers only for age")
	@Size(min=0, max=100, message ="Age must be greater than {min} and less than {max}")
	private String age;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Pattern(regexp = "[0-9]{10}" , message=" 10 digits mobile no. should be filled")
	private String mobileNumber;
	@Size(min=6,max=15, message="Password size should be between 6 and 15")
	private String password;
	private String skill;
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

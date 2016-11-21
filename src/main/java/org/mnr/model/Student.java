package org.mnr.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class Student {
//	@Min(value=1,message="Id length must be greater than two")
	@Min(value=1)
//	@Max(value=5,message="Id length must be less than five")

	private int id;
	
//	@Min(value=5,message="Id length must be greater than five")
//	@Max(value=10,message="Id length must be less than two ten")
//	@Length(min=8,message="Name length must be between five and ten" )
//	@Email
	@Length(min=8)
	private String name;
	
	@Email
	@Length(max=10)
	private String email;
	
	//private Subject subject;
	
//	public Subject getSubject() {
//		return subject;
//	}
//	public void setSubject(Subject subject) {
//		this.subject = subject;
//	}
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {  
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	

}

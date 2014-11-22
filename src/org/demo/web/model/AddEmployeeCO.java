package org.demo.web.model;

import java.io.Serializable;

public class AddEmployeeCO implements Serializable {
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String name;
	private String email;
	
	public String toString() {
	return "Person [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}

package com.project.model;

import javax.persistence.*;

@Entity
public class Authors {
	//Authors (id, name, gender, born)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Integer id;
	private String name;
	private String gender;
	private String born;
	
	public Authors() {}
	
	public Authors(String name, String gender, String born) {
		this.name = name;
		this.gender = gender;
		this.born = born;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	@Override
	public String toString() {
		return "Authors [id=" + id + ", name=" + name + ", gender=" + gender + ", born=" + born + "]";
	}
	
	
}

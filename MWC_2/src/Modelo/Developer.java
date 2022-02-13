package Modelo;


import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

	
	public class Developer implements Serializable{
	
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String phone;

	private java.util.Date date;
	
	private String categoria;
	
	private Set<Categoria> categories = new HashSet<>();

	public Developer() {
	}
	

	public Developer(String name, String email, String phone, String categoria) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.categoria = categoria;
	}


	public Developer(int id, String name, String email, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		
	}

	public Developer(int id, String name, String email, String phone, String categoria) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.categoria = categoria;
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

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Set<Categoria> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categoria> categories) {
		this.categories = categories;
	}
}

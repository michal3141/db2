package edu.agh.iisg.db.dto;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	private String surname;
	
	@Temporal(TemporalType.DATE)
	private Calendar dateOfBirth;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------------------------------------\n");
		sb.append("Name : " + getName() + "\n");
		sb.append("Surname : " + getSurname() + "\n");
		sb.append("Date of birth : " + getDateOfBirth().toString() + "\n");
		sb.append("---------------------------------------\n");
		return sb.toString();
	}
	
}

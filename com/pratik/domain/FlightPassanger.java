package com.pratik.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="FlightPassanger")

public class FlightPassanger {

	@Id
	@GenericGenerator(name="mygen",strategy="increment")
	@GeneratedValue(generator="mygen")
	private int passangerId;
	private String passangerName;
	private int age;
	private String gender;
	private float cost;

	@OneToOne(targetEntity=FlightTicket.class,
			cascade=CascadeType.ALL,mappedBy="passanger")
	
	private FlightTicket ticket;
	
	public FlightTicket getTicket() {
		return ticket;
	}
	public void setTicket(FlightTicket ticket) {
		this.ticket = ticket;
	}
	public int getPassangerId() {
		return passangerId;
	}
	public void setPassangerId(int passangerId) {
		this.passangerId = passangerId;
	}
	public String getPassangerName() {
		return passangerName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}

package com.pratik.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="FlightTicket")
public class FlightTicket {
	@Id
	@GenericGenerator(name="mygen",strategy="sequence",
				parameters=@Parameter
				(name="sequence_name",value="ticketSeq"))
	@GeneratedValue(generator="mygen")
	private int ticketNo;
	private String seatNo;
	private int flightNo;
	private String flightName;
	private String source;
	private String destination;
	
	@OneToOne(targetEntity=FlightPassanger.class,
			cascade=CascadeType.ALL)
	@JoinColumn(name="Ticket_Holder")
	private FlightPassanger passanger;
	
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public FlightPassanger getPassanger() {
		return passanger;
	}
	public void setPassanger(FlightPassanger passanger) {
		this.passanger = passanger;
	}
	
	
}

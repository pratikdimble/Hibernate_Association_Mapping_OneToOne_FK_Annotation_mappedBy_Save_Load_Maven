package com.pratik.dao;


import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pratik.domain.FlightPassanger;
import com.pratik.domain.FlightTicket;
import com.pratik.utility.HibernateUtil;

public class OTO_DAOImpl implements OTO_DAO {
 
	
	@Override
	public void SaveDataUsingTicket() {
	
		Session ses=null;
		Transaction tx=null;
		
		//get the session
		ses=HibernateUtil.getSession();
		//create the object and set the data
		
		FlightPassanger psngr=new FlightPassanger();
			psngr.setPassangerName("Pratik");
			psngr.setGender("Male");
			psngr.setAge(25);
			psngr.setCost(1500.00f);
			
			FlightTicket ticket=new FlightTicket();
				//ticket.setTicketNo(12345);
				ticket.setSeatNo("A22");
				ticket.setFlightNo(223);
				ticket.setSource("Pune");
				ticket.setDestination("Hyderabad");
				ticket.setFlightName("SpiceJet");
				
				ticket.setPassanger(psngr);
				psngr.setTicket(ticket);
				
				//save objs (parent to child)
				
				try{
				 tx=ses.beginTransaction();
				   ses.save(ticket);
				   ses.save(psngr);
				 tx.commit();
				 System.out.println("Objects are saved....");
				  }//try
				  catch(Exception e){
				    tx.rollback();
				    }
		
	}//SaveDataUsingTicket() method
	
	@Override
	public void loadDataUsingticket() {
		Session ses=null;
		Query query=null;
		List<FlightTicket> ticketsList=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//create Query obj
		query=ses.createQuery("from FlightTicket");
		//execute Query
		ticketsList=query.list();
		//process the Results
		for(FlightTicket ticket:ticketsList){
			System.out.println("Tickets---->"+ticket.getTicketNo()+" "+ticket.getFlightName()+" "+ticket.getFlightNo()+" "+ticket.getSeatNo()+" "+ticket.getSource()+" "+ticket.getDestination());
			//get all childs of each parent
			FlightPassanger flight=ticket.getPassanger();
			//System.out.println(ticketsList.size());
								System.out.println("Passanger--->"+flight.getPassangerId()+" "+flight.getPassangerName()+" "+flight.getAge()+" "+flight.getGender()+" "+flight.getCost());
					
			}//for
	}//loadDataUsingticket() method
	
}//class

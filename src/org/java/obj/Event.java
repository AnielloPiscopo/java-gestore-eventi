package org.java.obj;

import java.time.LocalDate;

import org.java.helper.*;

public class Event {
	private String title;
	private LocalDate date;
	private int totSeats;
	private static int bookedSeats = 0;
	
	
	
	public Event(String title, LocalDate date, int totSeats) throws Exception {
		setTitle(title);
		setDate(date);
		setTotSeats(totSeats);
	}


	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) throws Exception {
		Helper.isDatePassed(date);
		this.date = date;
	}
	
	
	public int getTotSeats() {
		return totSeats;
	}
	
	protected void setTotSeats(int totSeats) throws Exception {
		Helper.isNumPositive(totSeats);
		
		this.totSeats = totSeats;
	}
	
	public int getBookedPlaces() {
		return bookedSeats;
	}
	
	
	
	public void bookPlace() throws Exception {
		Helper.isDatePassed(date);
		
		if(totSeats<=0) throw new Exception("Non ci sono posti disponibili");
		
		bookedSeats++;
		totSeats--;
	}
	
	public void unbookPlace() throws Exception {
		Helper.isDatePassed(date);
		
		if(bookedSeats<=0) throw new Exception("Non ci sono posti prenotati");
		
		bookedSeats--;
		totSeats++;
	}
	
	protected String getEventInfo() {
		return "Titolo:" + getTitle() 
			+ "\nData:" + getDate();
	}
	
	public String getBookingsInfo() {
		return "Posti prenotati: " + getBookedPlaces()
			+ "\nPosti disponibili: " + getTotSeats();
	}


	@Override
	public String toString() {
		return getEventInfo();
	}
	
}

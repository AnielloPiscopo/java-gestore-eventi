package org.java.obj;

import java.time.LocalDate;

public class Event {
	private String title;
	private LocalDate date;
	private int totPlaces;
	private static int bookedPlaces = 0;
	
	
	
	public Event(String title, LocalDate date, int totPlaces) throws Exception {
		setTitle(title);
		setDate(date);
		setTotPlaces(totPlaces);
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
		isDatePassed(date);
		this.date = date;
	}
	
	
	public int getTotPlaces() {
		return totPlaces;
	}
	
	private void setTotPlaces(int totPlaces) throws Exception {
		if(totPlaces <= 0) throw new Exception("Hai inserito un numero negativo per il numero totale di posti dell'evento");
		
		this.totPlaces = totPlaces;
	}
	
	public int getBookedPlaces() {
		return bookedPlaces;
	}
	
	
	
	public void bookPlace() throws Exception {
		isDatePassed(date);
		
		if(totPlaces<=0) throw new Exception("Non ci sono posti disponibili");
		
		bookedPlaces++;
	}
	
	public void unbookPlace() throws Exception {
		isDatePassed(date);
		
		if(bookedPlaces<=0) throw new Exception("Non ci sono posti prenotati");
		
		bookedPlaces--;
	}
	
	public void isDatePassed(LocalDate d) throws Exception {
		if(d.compareTo(LocalDate.now())<0) throw new Exception("La data già è passata");
	}


	@Override
	public String toString() {
		return "Titolo:" + getTitle() 
				+ "\nData:" + getDate();
	}
	
}

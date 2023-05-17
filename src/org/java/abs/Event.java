package org.java.abs;

import java.time.LocalDate;

public abstract class Event {
	private String title;
	private LocalDate date;
	private int totPlaces;
	private static int bookedPlaces = 0;
	
	
	
	public Event(String title, LocalDate date, int totPlaces) {
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
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	public int getTotPlaces() {
		return totPlaces;
	}
	
	private void setTotPlaces(int totPlaces) {
		this.totPlaces = totPlaces;
	}
	
	
	
	public void bookPlace() {
		bookedPlaces++;
	}
	
	public void unbookPlace() {
		bookedPlaces--;
	}


	@Override
	public String toString() {
		return "Titolo:" + getTitle() 
				+ "\nData:" + getDate()
				+ "]";
	}
	
}

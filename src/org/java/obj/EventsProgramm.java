package org.java.obj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventsProgramm {
	private String title;
	private List<Event> events;
	
	
	public EventsProgramm(String title) {
		setTitle(title);
		setEvents();
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public List<Event> getEvents() {
		return events;
	}
	
	private void setEvents() {
		events = new ArrayList<>();
	}
	
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	public int getNumOfEvents() {
		return events.size();
	}
	
	public void deleteEvents() {
		events.clear();
	}
	
	public List<Event> filterEvents(LocalDate date) {
		List <Event> filteredEvents = events.stream().filter(e -> e.getDate().compareTo(LocalDate.now()) == 0).collect(Collectors.toList());
		return filteredEvents;
	}
	
	private String getInfo() {
		return "Titolo: " + getTitle()
			+ "\n" + getEvents();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getInfo();
	}
}

package org.java.obj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	public List<Event> getFilterEvents(LocalDate date) {
		List <Event> filteredEvents = getEvents().stream().filter(e -> e.getDate().compareTo(date) == 0).collect(Collectors.toList());
		return filteredEvents;
	}
	
	public List<Event> getSortedByDateEvents(){
		List<Event> sortedEvents = getEvents();
		Collections.sort(sortedEvents , new Comparator<Event>() {
			public int compare(Event e1 , Event e2) {
				return e1.getDate().compareTo(e2.getDate());
			}
		} );
		
		return sortedEvents;
	}
	
	private String getEventInfo() {
		String eventInfo = "";
		
		for(int i=0 ; i<getSortedByDateEvents().size() ; i++) {
			Event event = getSortedByDateEvents().get(i);
			eventInfo += "\n" + (i+1) + ")" + event.getMinimalEventInfo();
		}
		
		return eventInfo;
	}
	
	private String getInfo() {
		return "Titolo Programma Eventi: " + getTitle()
			+ "\nLista Eventi: " + (getEventInfo().isBlank() ? "vuota" : getEventInfo());
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getInfo();
	}
}

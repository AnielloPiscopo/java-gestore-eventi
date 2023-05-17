package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.java.obj.*;
import org.java.helper.*;

public class Main {
	private Main() throws Exception {
		run();
	}

	
	private void run() throws Exception {
		Scanner sc = new Scanner(System.in);
		
		
//		Event event = createEvent(sc);
//		if(event != null) {
//			makeBookings(event , sc);
//			cancelBookings(event , sc);
//		}
		
		Concert concert = createConcert(sc);
		if(concert != null) {			
			makeBookings(concert , sc);
			cancelBookings(concert , sc);
		}
		
		
		sc.close();
	}
	
	
	private Event createEvent(Scanner sc) {
		System.out.println("Inserisci le informazioni dell'evento");
		Event e = null;
		
		try {
			System.out.println("Inserisci il titolo");
			String title = sc.nextLine();
			sc.nextLine();
			System.out.println("Inserisci il giorno");
			int day = sc.nextInt();
			Helper.isNumPositive(day);
			System.out.println("Inserisci il mese");
			int mounth = sc.nextInt();
			Helper.isNumPositive(mounth);
			System.out.println("Inserisci l'anno");
			int year = sc.nextInt();
			Helper.isNumPositive(year);
			System.out.println("Inserisci il numero di posti totali");
			int totSeats = sc.nextInt();
			Helper.isNumPositive(totSeats);
			
			e = new Event(title , LocalDate.of(year, mounth, day) , totSeats);
			System.out.println(e);
		}catch(Exception err) {
			System.err.println("Errore: " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
		}
		
		return e;
	}
	
	private Concert createConcert(Scanner sc) {
		System.out.println("Inserisci le informazioni del concerto");
		Concert c = null;
		
		try {
			System.out.println("Inserisci il titolo");
			String title = sc.nextLine();
			sc.nextLine();
			System.out.println("Inserisci il giorno");
			int day = sc.nextInt();
			Helper.isNumPositive(day);
			System.out.println("Inserisci il mese");
			int mounth = sc.nextInt();
			Helper.isNumPositive(mounth);
			System.out.println("Inserisci l'anno");
			int year = sc.nextInt();
			Helper.isNumPositive(year);
			System.out.println("Inserisci il numero di posti totali");
			int totSeats = sc.nextInt();
			Helper.isNumPositive(totSeats);
			System.out.println("Inserisci l'ora");
			int hours = sc.nextInt();
			Helper.isNumPositive(hours);
			System.out.println("Inserisci i minuti");
			int minutes = sc.nextInt();
			Helper.isNumPositive(minutes);
			System.out.println("Inserisci il prezzo");
			BigDecimal price = sc.nextBigDecimal();
			
			c = new Concert(title , LocalDate.of(year, mounth, day) , totSeats , LocalTime.of(hours, minutes) , price);
			System.out.println(c);
		}catch(Exception err) {
			System.err.println("Errore: " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
		}
		
		return c;
	}
	
	
	private void makeBookings(Event e , Scanner sc) {
		try {
			System.out.println("Vuoi prenotare per l'evento?");
			boolean userChoise = sc.nextBoolean();
			
			if(!userChoise) return;
			
			sc.nextLine();
			
			System.out.println("Quante prenotazioni vuoi effettuare?");
			int bookingsNum = sc.nextInt();
			Helper.isNumPositive(bookingsNum);
			
			for(int i=0 ; i<bookingsNum ; i++) {
				e.bookPlace();
			}
			
			System.out.println(e.getBookingsInfo());
		}catch(Exception err){
			System.err.println("Errore: " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
		}
	}
	
	private void cancelBookings(Event e , Scanner sc) {
		try {
			System.out.println("Vuoi disdire una prenotazione o più?");
			boolean userChoise = sc.nextBoolean();
			
			if(!userChoise) return;
			
			sc.nextLine();
			
			System.out.println("Quante prenotazioni vuoi disdire?");
			int bookingsNum = sc.nextInt();
			Helper.isNumPositive(bookingsNum);
			
			for(int i=0 ; i<bookingsNum ; i++) {
				e.unbookPlace();
			}
			
			System.out.println(e.getBookingsInfo());
		}catch(Exception err) {
			System.err.println("Errore: " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
		}
	}


	public static void main(String[] args) throws Exception {
		new Main();
	}
	
	
}

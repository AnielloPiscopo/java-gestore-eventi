package org.java;

import java.time.LocalDate;
import java.util.Scanner;

import org.java.obj.*;
import org.java.helper.*;

public class Main {
	private Main() throws Exception {
		run();
	}

	
	private void run() throws Exception {
		Scanner sc = new Scanner(System.in);
		Event event = createEvent(sc);
		makeBookings(event , sc);
		cancelBookings(event , sc);
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
			System.out.println("Inserisci l'anno");
			int year = sc.nextInt();
			System.out.println("Inserisci il numero di posti totali");
			int totSeats = sc.nextInt();
			
			e = new Event(title , LocalDate.of(year, mounth, day) , totSeats);
			System.out.println(e);
		}catch(Exception err) {
			System.err.println("Errore: " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
		}
		
		return e;
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
		}catch(Exception err) {}
	}


	public static void main(String[] args) throws Exception {
		new Main();
	}
	
	
}

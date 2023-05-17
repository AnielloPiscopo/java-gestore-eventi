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
		
		manageEventProgramm(sc);
		sc.close();
	}
	
	private void manageEventProgramm(Scanner sc) {
		EventsProgramm ep = null;
		
		try {
			System.out.println("Come vuoi chiamare il tuo programma evento? ");
			String title = sc.nextLine();
			
			ep = new EventsProgramm(title);
			
			int userChoise = 0;
			
			do {
				sc.nextLine();
				System.out.println("\n-------------------------------------------\n");
				System.out.println("Cosa vuoi fare ora:"
						+ "\n1)Aggiungere evento;"
						+ "\n2)Cercare evento/i in base a una data;"
						+ "\n3)Visualizzare gli eventi;"
						+ "\n4)Visualizzare il numero degli eventi in programma;"
						+ "\n5)Svuotare la lista degli eventi;"
						+ "\n6)Gestisci prenotazioni;"
						+ "\n7)Gestisci cancellazioni;"
						+ "\n8)Uscire dal programma;");
				
				userChoise = sc.nextInt();
				
				switch(userChoise) {
					case 1:{
						System.out.println("Vuoi che sia un concerto? ");
						boolean isAConcert = sc.nextBoolean();
						
						Event event = (isAConcert) ? createConcert(sc) : createEvent(sc);
						
						System.out.println("\n-------------------------------------\n");
						System.out.println(event);
						System.out.println("\n-------------------------------------\n");
						
						ep.addEvent(event);
						break;}
					case 2:
						LocalDate date = Helper.getDateFromUserValues(sc);
						System.out.println("\n-------------------------------------\n");
						System.out.println(
								ep.getNumOfEvents()<=0 
								? "Non puoi eseguire questa azione perchè la lista è vuota" 
								: ep.getFilterEvents(date));
						System.out.println("\n-------------------------------------\n");
						break;
					case 3:
						System.out.println("\n-------------------------------------\n");
						System.out.println(ep);
						System.out.println("\n-------------------------------------\n");
						break;
					case 4:
						System.out.println(ep.getNumOfEvents());
						break;
					case 5:
						ep.deleteEvents();
						if(ep.getNumOfEvents()<=0) System.out.println("La lista è già vuota");
						break;
					case 6:{
						if(ep.getNumOfEvents()>0) {
							System.out.println("Scegli l'evento di cui ti vuoi occupare");
							int eventNum = sc.nextInt();
							Event event = ep.getEvents().get(eventNum-1);
							makeBookings(event, sc);
						}else {
							System.out.println("Non puoi eseguire questa azione perchè la lista è vuota");
						}
						break;}
					case 7:{
						if(ep.getNumOfEvents()>0) {
							System.out.println("Scegli l'evento di cui ti vuoi occupare");
							int eventNum = sc.nextInt();
							Event event = ep.getEvents().get(eventNum-1);
							cancelBookings(event, sc);
						}else {
							System.out.println("Non puoi eseguire questa azione perchè la lista è vuota");
						}
						break;}
					case 8:
						System.out.println("Sei uscito dal programma");
						break;
					default:
						System.out.println("Valore non disponibile tra le opzioni");
						break;
				}
			}while(userChoise!=8);
		}catch(Exception err) {
			System.err.println("Errore nella creazione del programma di eventi: " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
		}
	}
	
	
	private Event createEvent(Scanner sc) {
		System.out.println("Inserisci le informazioni dell'evento");
		Event e = null;
		
		try {
			System.out.println("Inserisci il titolo");
			sc.nextLine();
			String title = sc.nextLine();
			LocalDate date = Helper.getDateFromUserValues(sc);
			System.out.println("Inserisci il numero di posti totali");
			int totSeats = sc.nextInt();
			Helper.isNumPositive(totSeats);
			
			e = new Event(title , date , totSeats);
			System.out.println(e);
		}catch(Exception err) {
			System.err.println("Errore nella creazione dell'evento: " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
		}
		
		return e;
	}
	
	private Concert createConcert(Scanner sc) {
		System.out.println("Inserisci le informazioni del concerto");
		Concert c = null;
		
		try {
			System.out.println("Inserisci il titolo");
			sc.nextLine();
			String title = sc.nextLine();
			LocalDate date = Helper.getDateFromUserValues(sc);
			System.out.println("Inserisci il numero di posti totali");
			int totSeats = sc.nextInt();
			Helper.isNumPositive(totSeats);
			LocalTime time = Helper.getTimeFromUserValues(sc);
			System.out.println("Inserisci il prezzo");
			BigDecimal price = sc.nextBigDecimal();
			
			c = new Concert(title , date , totSeats , time , price);
			System.out.println(c);
		}catch(Exception err) {
			System.err.println("Errore nella creazione del concerto: " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
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
			System.err.println("Errore nella gestione delle prenotazioni : " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
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
			System.err.println("Errore nella cancellazione delle prenotazioni: " + (err.getMessage() == null ? "Hai inserito un valore non valido" : err.getMessage()));
		}
	}


	public static void main(String[] args) throws Exception {
		new Main();
	}
	
}

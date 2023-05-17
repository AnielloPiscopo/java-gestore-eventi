package org.java.helper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public abstract class Helper {
	public static void isNumPositive(int num) throws Exception {
		if(num<=0) throw new Exception("Hai inserito un valore negativo o uguale a 0");
	}
	
	public static void isDatePassed(LocalDate d) throws Exception {
		if(d.compareTo(LocalDate.now())<0) throw new Exception("La data già è passata");
	}
	
	public static LocalDate getDateFromUserValues(Scanner sc) throws Exception {
		System.out.println("Inserisci il giorno");
		int day = sc.nextInt();
		isNumPositive(day);
		System.out.println("Inserisci il mese");
		int mounth = sc.nextInt();
		isNumPositive(mounth);
		System.out.println("Inserisci l'anno");
		int year = sc.nextInt();
		isNumPositive(year);
		
		return LocalDate.of(year, mounth, day);
	}
	
	public static LocalTime getTimeFromUserValues(Scanner sc) throws Exception{
		System.out.println("Inserisci l'ora");
		int hours = sc.nextInt();
		isNumPositive(hours);
		System.out.println("Inserisci i minuti");
		int minutes = sc.nextInt();
		isNumPositive(minutes);
		
		return LocalTime.of(hours, minutes);
	}
}

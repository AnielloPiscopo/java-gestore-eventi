package org.java;

import java.time.LocalDate;

import org.java.obj.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Event e1 = new Event("asd" , LocalDate.of(2023, 05, 16) , 12);
		
		
		e1.bookPlace();
		System.out.println(e1.getBookedPlaces());
	}
}

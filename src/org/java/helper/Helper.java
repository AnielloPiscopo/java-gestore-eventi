package org.java.helper;

import java.time.LocalDate;

public abstract class Helper {
	public static void isNumPositive(int num) throws Exception {
		if(num<=0) throw new Exception("Hai inserito un valore negativo o uguale a 0");
	}
	
	public static void isDatePassed(LocalDate d) throws Exception {
		if(d.compareTo(LocalDate.now())<0) throw new Exception("La data già è passata");
	}
}

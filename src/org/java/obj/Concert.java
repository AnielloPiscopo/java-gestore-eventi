package org.java.obj;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event {
	private LocalTime hours;
	private BigDecimal price;

	public Concert(String title, LocalDate date, int totSeats) throws Exception {
		super(title, date, totSeats);
		// TODO Auto-generated constructor stub
	}

	public LocalTime getHours() {
		return hours;
	}

	public void setHours(LocalTime hours) {
		this.hours = hours;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()
				+ "\nOre: " + getHours()
				+ "\nPrezzo: " + getPrice() + "$";
	}
	
	

}

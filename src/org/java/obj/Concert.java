package org.java.obj;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event {
	private LocalTime time;
	private BigDecimal price;

	public Concert(String title, LocalDate date, int totSeats , LocalTime time , BigDecimal price) throws Exception {
		super(title, date, totSeats);
		setTime(time);
		setPrice(price);
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
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
				+ "\nOre: " + getTime()
				+ "\nPrezzo: " + String.format("%.2f", getPrice()) + "$";
	}
	
	

}

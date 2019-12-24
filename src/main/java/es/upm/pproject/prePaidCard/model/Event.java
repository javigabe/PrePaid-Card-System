package es.upm.pproject.prePaidCard.model;

import java.util.Date;

public class Event {
	
	Date date;
	double amount;

	public Event (Date date, double amount) {
		this.date = date;
		this.amount = amount;
	}
	
	public String toString() {
		return date.toString() + "\t" + amount + "\r\n";
	}
}

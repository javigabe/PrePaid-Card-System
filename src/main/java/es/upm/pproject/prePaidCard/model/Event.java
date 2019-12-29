package es.upm.pproject.prePaidCard.model;

import java.util.Date;

public class Event {
	
	Date date;
	long amount;

	public Event (Date date, long amount) {
		this.date = date;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return date.toString() + "\t" + amount + "\r\n";
	}
}

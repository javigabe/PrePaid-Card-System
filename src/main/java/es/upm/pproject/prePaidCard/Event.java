package es.upm.pproject.prePaidCard;

import java.util.Date;

public class Event {
	
	Date date;
	double amount;

	public Event (Date date, double amount) {
		this.date = date;
		this.amount = amount;
	}
	
	public String print() {
		String res = "";
		res += date.toString() + "   ";
		res += amount + "\r\n";		
		return res;
	}
}

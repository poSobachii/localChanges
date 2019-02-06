package x025.SpringBasicsLessons.SpringBasicsLesson5.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Huent {
	
	private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
	
	private int id;
	private String msg;
	private Date date;

	private DateFormat dateFormat;
	
	public Huent(Date date, DateFormat df) {
		this.id = AUTO_ID.getAndIncrement();
		
		this.date = date;
		this.dateFormat = df;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}


	public String toString() {
		return "THE FIFTH EMINEM [id=" + id + ", msg=" + msg + ", date=" + dateFormat.format(date) + "]";
	}

	private void starting(){
		Client.TimeCheck("Huent bean");
	}

}

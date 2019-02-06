package x025.SpringBasicsLessons.SpringBasicsLesson5.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String id;

	private String fullName;

	public Client(String id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}
	public static void TimeCheck(String text){
		long duration = System.currentTimeMillis();
		DateFormat simple = new SimpleDateFormat("HH:mm:ss:SSS");
		Date result = new Date(duration);
		System.out.println(text + " is created at: " + simple.format(result));
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private void starting(){
		TimeCheck("Client bean");
	}


}

package x024.SpringTests.SpringTests.webTests.JodaTest;

import org.joda.time.LocalTime;

public class HelloTime {
	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
	}
}

package x025.SpringBasicsLessons.SpringBasicsLesson5.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Huent;
import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

	private int cacheSize;
	private List<Huent> cache;

	public CacheFileEventLogger(String filename, int cacheSize) {
		super(filename);
		this.cacheSize = cacheSize;
		this.cache = new ArrayList<Huent>(cacheSize);
	}
	
	public void destroy() {
		ending();
		if ( ! cache.isEmpty()) {
			writeEventsFromCache();
		}
	}

	@Override
	public void logEvent(Huent event) {
		cache.add(event);
		
		if (cache.size() == cacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}

	private void writeEventsFromCache() {
	    cache.stream().forEach(super::logEvent);
	}

	private void starting(){
		Client.TimeCheck("CacheFileEventLogger bean");
	}

	public static void ending(){
		long duration = System.currentTimeMillis();
		DateFormat simple = new SimpleDateFormat("mm:ss:SSS");
		Date result = new Date(duration);
		System.out.println("CacheFileEventLogger bean is Destroyed at: " + simple.format(result));
	}
}

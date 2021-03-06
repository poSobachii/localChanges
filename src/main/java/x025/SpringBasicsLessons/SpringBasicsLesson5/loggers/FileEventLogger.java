package x025.SpringBasicsLessons.SpringBasicsLesson5.loggers;

import org.apache.commons.io.FileUtils;
import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Huent;
import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Client;
import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLoggerINTRAFACE {
	
	private File file;
	private String filename;
	
	public FileEventLogger(String filename) {
		this.filename = filename;
	}
	
	public void huinit() {
		Client.TimeCheck("FileEventlogger bean");
		file = new File(filename);
		if (file.exists() && !file.canWrite()) {
			throw new IllegalArgumentException("Can't write to file " + filename);
		} else if (!file.exists()) {
		    try {
		        file.createNewFile();
		    } catch (Exception e) {
		        throw new IllegalArgumentException("Can't create file", e);
		    }
		    
		}
	}

	@Override
	public void logEvent(Huent event) {
		try {
			FileUtils.writeStringToFile(file, event.toString(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

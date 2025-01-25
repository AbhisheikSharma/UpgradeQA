package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingApache {
	
	static final Logger log = LogManager.getLogger(LoggingApache.class.getName());
	
	public static void main(String[] args) {
		log.info("Info message");
		log.debug("Debug message");
		log.error("Error message");
		log.warn("Warn message");
	}

}

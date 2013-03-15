package com.cerberus.server.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ServerLogger {

	static private FileHandler fileTxt;
	static private StdoutConsoleHandler consoleHandler;
	static private SimpleFormatter formatterTxt;
	
	public static void setup (String logFilename){
		// Get the global logger to configure it
	    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	    logger.setLevel(Level.INFO);
	   
	    //Bind the handlers
	    try {
			fileTxt = new FileHandler(logFilename);
			consoleHandler = new StdoutConsoleHandler();
		} catch (SecurityException e) {
			System.out.println("Problem creating the log file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem creating the log file.");
			e.printStackTrace();
		}

	    // Create txt Formatter
	    formatterTxt = new SimpleFormatter();
	    fileTxt.setFormatter(formatterTxt);
	    
	    logger.setUseParentHandlers(false);
	    
	    //Log to console with .out for info and .err for above info
	    logger.addHandler(consoleHandler);
	    
	    //Log to text file
	    logger.addHandler(fileTxt);
	    
	    
	}
}

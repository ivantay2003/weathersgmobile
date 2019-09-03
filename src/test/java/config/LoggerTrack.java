/*
 * 	Copyright (c) 2019 Ivan Tay 
 *  Logger
 * 
 */

package config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerTrack {

	public static Logger logger ;
	private static boolean setlog;
	
	public static void setInitialize (Class gClass){
		logger = Logger.getLogger(LoggerTrack.class);
		setlog = true;
		log();
		
	}
	
	private static void log(){
	//log4j config

		//Logger logger = Logger.getLogger(BaseTestAndroid.class);

		
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
		logger.info("Logger started.... ");
	
		
	
		
	}
	
	public static void setInfo (String text){
		
		if (setlog)
			logger.info(text);
	}
}

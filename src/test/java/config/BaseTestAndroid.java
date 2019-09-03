/*
 * 	Copyright (c) 2019 Ivan Tay All rights reserved
 * 
 *  Base class setup for Android 
 * 
 */
package config;


import browserdriver.BrowserType;
import page.PageObjectManager;
import report.ExtentTestManager;

public class BaseTestAndroid {
	



	
	//public static Logger logger = Logger.getLogger(BaseTestAndroid.class);
	private Configuration config;
	public BaseTestAndroid (String reportFileName){
		
		ExtentTestManager.getInstance(reportFileName); // Extent Report filename
		setInitializeAndroid();
	}
	
	private void setInitializeAndroid(){
	//Initialize appium driver, page objects manager, project configuration
		
		config = new Configuration();
		
		String media_path  = System.getProperty("user.dir")+ "/Desiredcap/";
		System.out.println(media_path);
		String androidfile = "android_weathersg.json";
		String jsonFile = media_path + androidfile;
		  
		config.setBrowser(BrowserType.ANDROID,jsonFile);//Use Android driver
		PageObjectManager.setInitializePageObjects (config); //Initialize all Page Objects Models with project configurations / web driver / user data
		LoggerTrack.setInitialize(BaseTestAndroid.class);
		LoggerTrack.setInfo("Test start");

		

	}
	
	public Configuration getConfig(){
		
		return config;
	}
	
	public void endTest (){
		
		ExtentTestManager.endReport(); //Write report
		PageObjectManager.closeApp();
		  
		LoggerTrack.setInfo("Test end ");		

	}
	

}

/*
 * 	Copyright (c) 2018 Ivan Tay 
 *  Page Object Manager. Controls all the pages 
 *  
 */

package page;
 

import Appium_Objects.selenoid; // Common modules
import config.Configuration;

public class PageObjectManager {

	
	//Page objects
	public static Android_LaunchPage launchPage;
	public static Android_BottombarPage bottombarPage;
	public static Android_24HourPage hour24Page;

	
	private static Configuration config ; //Configuration object
	private static selenoid sel ; // Common extension selenium module
	
	public static void setInitializePageObjects (Configuration inputConfig){
		/*
		 * Create an instance of page objects , 
		 * Initialize all pages with configuration 
		 * Get the web drivers for common
		 */
		
		config = inputConfig;
		sel = config.getSelenoid();

		launchPage = new Android_LaunchPage (config,sel);
		bottombarPage = new Android_BottombarPage (config,sel);
		hour24Page = new Android_24HourPage (config,sel);
		

		

	}
	
	public static void closeApp (){
		//Close app
		config.getAndroidDriver().quit();
	}
	
	public static void androidScrollDown(int x1,int y1,int x2,int y2){
		

		sel.androidScrollDown( x1, y1,x2, y2 );

	}
	
	public static String randomEmail (){
		
		return sel.randomEmail();
	}
	
	
	

}

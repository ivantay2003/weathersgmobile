/*
 * 	Copyright (c) 2019 Ivan Tay All rights reserved
 * 
 * Script for Test Scenario 24 hour weather forecast on android and restapi
 * 
 */

package scenarios_android;

import org.testng.annotations.Test;

import report.ExtentTestManager;
import validation.CompareAPIUI;
import config.BaseTestAndroid;
import config.MenuType;
import page.PageObjectManager;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class T1_24hourforecast extends PageObjectManager{

	private CompareAPIUI validation = new CompareAPIUI ();
	private BaseTestAndroid baseTest;

	public void setup (){

		baseTest = new BaseTestAndroid ("TestReport_android_24hour");
		  
	}
  @BeforeTest
  public void beforeTest() {
	  
	  setup();
  }

  @AfterTest
  public void afterTest() {
	
	  baseTest.endTest();
  }

  @Test
  public void start() {
	  
	  //Test scenario - T1
	  /* Launch weather@sg android
	   * Click on the bottom bar menu button "24 hour forecast" page
	   * Extract all the mobile elements text from 24 hour forecast - temperature , humidity , wind speed , direction example
	   * Break up the mobile element strings
	   * Compare the mobile element text with the backend restapi strings 
	   * Generate a report and log
	   */
	  
	  
	  
	  //Landing page
	  ExtentTestManager.createSection("App launch");
	  launchPage.permissionLocation(true); //Click ok to allow permission to access device
	
	  //Bottom Bar Page
	  Assert.assertEquals( bottombarPage.pageExist(), true,"Bottombar page not detected");
	  bottombarPage.selectMenu(MenuType.HOUR24); //Click on 24 hour forecast button 
	  
	  //24 hour forecast page
	  Assert.assertEquals( hour24Page.pageExist(), true,"24 hour page not detected");

	  //Compare the mobile elements texts with backend restapi strings
	  validation.compare24HourForecast();
	  
  }
}

/*
 * 	Copyright (c) 2019 Ivan Tay All rights reserved
 * 
 *  Validation mobile and api 
 * 
 */

package validation;

import com.aventstack.extentreports.Status;

import page.PageObjectManager;
import restapi.WeatherForecastSG24Hours;
import report.ExtentTestManager;

public class CompareAPIUI {

	private String errorMessage ;
	
	public CompareAPIUI (){
		
		errorMessage ="";
	}
	
	public void compare24HourForecast(){
	// Compare the mobile 24 hour forecast on android with rest api 
	// Write the result in Extent Report
		
		String message = "API 24 hour forecast ";
		errorMessage ="";
		
		if (!compare24Hour()){
			  message = message + ": " + errorMessage;
			  ExtentTestManager.logTest(message, Status.FAIL);
		}else
			  ExtentTestManager.logTest(message, Status.PASS);
		
	}
	
	private boolean compare24Hour (){
	/*2 tasks 
	 * 1. Collect all the api strings from backend
	 * 2. Compare 1 & 2 . If ok , return true. Otherwise false
	 * 	
	 */
		if (PageObjectManager.hour24Page.pageExist()){
			
			WeatherForecastSG24Hours.setInitialize(); //Initialize Rest API manager
			  
			//Get the data from restAPI (Task 2)
			  if (WeatherForecastSG24Hours.getStatusCode()==200){
				  float temperaturehi_api = WeatherForecastSG24Hours.getHighTemperature();
				  float temperaturelo_api = WeatherForecastSG24Hours.getLowTemperature();
				  int windspeedhi_api = WeatherForecastSG24Hours.getHighWindSpeed();
				  int windspeedlo_api = WeatherForecastSG24Hours.getLowWindSpeed();
				  String winddirection_api = WeatherForecastSG24Hours.getWindDirection();
				  
				  
				 // Do task 3 since we have the mobile elements text strings
				  if (temperaturehi_api != PageObjectManager.hour24Page.getHighTemperature()){
					  
					  errorMessage = "Temperature Hi ";
					  return false;
					  
				  }
				  
				  if (temperaturelo_api != PageObjectManager.hour24Page.getLowTemperature()){
					  
					  errorMessage = "Temperature Lo ";
					  return false;
					  
				  }

				  
				  if (!winddirection_api.equals(PageObjectManager.hour24Page.getWindDirection())){
					  
					  errorMessage = "Wind direction ";
					  return false;
					  
				  }
				  
				  
				  if (windspeedhi_api != PageObjectManager.hour24Page.getHighWindSpeed()){
					  
					  errorMessage = "High Wind Speed ";
					  return false;
					  
				  }
				  
				  if (windspeedlo_api != PageObjectManager.hour24Page.getLowWindSpeed()){
					  
					  errorMessage = "Low Wind Speed ";
					  return false;
					  
				  }

			  }
		}else
			return false;
		
		return true;
	}
	

}

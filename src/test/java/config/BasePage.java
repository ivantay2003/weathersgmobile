/*
 * 	Copyright (c) 2018 Ivan Tay All rights reserved
 * 
 * Base Page inheritance 
 * 
 */

package config;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import report.ExtentTestManager;



public class BasePage  {
	

	public void validateCompareString(String expectedResult , String actualResult) {
		/*
		 * Compare strings and assert for result
		 */
		
		Assert.assertEquals(expectedResult, actualResult); //Compare actual and expected. Assert if false
		

	}
	
	public void validateCompareString(String expectedResult , String actualResult, String message) {
		/*
		 * Compare strings and assert for result
		 */
		
		
		try{
			Assert.assertEquals(expectedResult, actualResult, message); //Compare actual and expected. Assert if false
			ExtentTestManager.logTest(message, Status.PASS);
			
		}catch (Throwable error){
			
			ExtentTestManager.logTest(message + ". Error Message : " + error, Status.FAIL);
		}
		

	}
	
	public void validateNotNull ( Object obj, String message){
		
		try {
			Assert.assertNotNull( obj,message);
			ExtentTestManager.logTest(message, Status.PASS);
			
		}catch (Throwable error) {
			
			ExtentTestManager.logTest(message + ". Error Message : " + error, Status.FAIL);
			
		}
		
		
	}
	
	public void validateCompareBoolean(boolean expectedResult , boolean actualResult, String message){
		
		try {
			
			Assert.assertEquals(actualResult, expectedResult, message);
		}catch (Throwable error) {
			
			//ExtentTestManager.logTest(message + ". Error Message : " + error, Status.FAIL);
			
		}
		
	}
}

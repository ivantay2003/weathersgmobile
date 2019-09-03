/*
 * 	Copyright (c) 2019 Ivan Tay All rights reserved
 * 
 * Bottombar Page
 * 
 */

package page;

import org.openqa.selenium.By;
import Appium_Objects.selenoid;
import loc.LOCELEMENT_ANDROID;
import config.BasePage;
import config.Configuration;
import config.LoggerTrack;
import config.MenuType;



public class Android_BottombarPage extends BasePage {

	private  Configuration config; // Config

	private selenoid sel ;
	public Android_BottombarPage (Configuration configInput, selenoid inputsel){
		
		config = configInput;
		sel = inputsel;

		
	}
	
	public boolean pageExist(){
	//Page exist
		LoggerTrack.setInfo("Android_BottombarPage launch ");
		return sel.isPresence(By.id(LOCELEMENT_ANDROID.bottombar_id));
	
	}
	
	public void selectMenu(MenuType menuSelect){
		
		//List <AndroidElement> elements  = sel.getElements(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath));
		
		//System.out.printf ("Elements size :%d\n" , elements.size());
		
		switch (menuSelect){
		
			case WARNING:
				sel.clickElement(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[0]"));
				break;
			case LOCATION:
				sel.clickElement(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[1]"));
				break;
			case RAIN:
				sel.clickElement(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[2]"));
				break;
			case CURRENTOBSERVATION:
				sel.clickElement(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[3]"));
				break;
			case HOUR2:
				sel.clickElement(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[4]"));
				break;
			case HOUR24:
				sel.clickElement(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[6]"));
				break;
//			case DAY4:
//				if (!sel.isPresence(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[6]")))
//					swipe();
//				sel.clickElement(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[2]"));
//				break;
//			case SATELLITE:
//				if (!sel.isPresence(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[7]")))
//					swipe();
//				sel.clickElement(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[3]"));
//				break;
//			case INFO:
//				if (!sel.isPresence(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[8]")))
//					swipe();
//				sel.clickElement(By.xpath(LOCELEMENT_ANDROID.bottombarframe_xpath+"[4]"));
//				break;
//				
			
		
		}
		
		
	}

 
	
}

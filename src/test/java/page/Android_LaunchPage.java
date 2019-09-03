/*
 * 	Copyright (c) 2019 Ivan Tay All rights reserved
 * 
 * Launch Page 
 * 
 */

package page;

import org.openqa.selenium.By;

import Appium_Objects.selenoid;
import loc.LOCELEMENT_ANDROID;
import config.BasePage;
import config.Configuration;
import config.LoggerTrack;

public class Android_LaunchPage extends BasePage {

	private selenoid sel ;
	public Android_LaunchPage (Configuration configInput, selenoid inputsel){
		
		sel = inputsel;

	}
	
	public void permissionLocation(boolean setting){
	//Do we allow permission setting ?
		
		if (setting)
			if (sel.isPresence(By.id(LOCELEMENT_ANDROID.allow_id))){
				sel.clickElement(By.id(LOCELEMENT_ANDROID.allow_id));
				LoggerTrack.setInfo("permissionLocation true ");
			}
		else
			if (sel.isPresence(By.id(LOCELEMENT_ANDROID.deny_id))){
				sel.clickElement(By.id(LOCELEMENT_ANDROID.deny_id));
				LoggerTrack.setInfo("permissionLocation false ");
			}	
		  
	}
	

	
}

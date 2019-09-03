/*
 * 	Copyright (c) 2019 Ivan Tay All rights reserved
 * 
 * 24 hour forecast Page
 * 
 */

package page;

import java.util.ArrayList;

import org.openqa.selenium.By;
import Appium_Objects.selenoid;
import loc.LOCELEMENT_ANDROID;
import util.StringBreaker;
import config.BasePage;
import config.Configuration;
import config.LoggerTrack;

public class Android_24HourPage extends BasePage {
	
	//Variables
	private float temperaturehi, temperaturelo;
	private String humidity, winddirection, windspeeddirection;
	private String [] humidityarr;
	private ArrayList<Integer> windspeed;
	
	private StringBreaker util = new StringBreaker();
	private  Configuration config; // Config

	private selenoid sel ;
	public Android_24HourPage (Configuration configInput, selenoid inputsel){
		
		config = configInput;
		sel = inputsel;
		
	}
	
	public boolean pageExist (){
	//Collect all the strings from elements in this page	
		
		
		if (sel.isPresence(By.id(LOCELEMENT_ANDROID.temperaturehi_id))) {
			temperaturehi = Float.parseFloat(config.getAndroidDriver().findElement(By.id(LOCELEMENT_ANDROID.temperaturehi_id)).getText());
			temperaturelo = Float.parseFloat(config.getAndroidDriver().findElement(By.id(LOCELEMENT_ANDROID.temperaturelo_id)).getText());
			config.getAndroidDriver().findElement(By.id(LOCELEMENT_ANDROID.winddirection_id)).getText();
			humidity = config.getAndroidDriver().findElement(By.id(LOCELEMENT_ANDROID.humidity_id)).getText();
			windspeeddirection = config.getAndroidDriver().findElement(By.id(LOCELEMENT_ANDROID.windspeeddirection_id)).getText();
			
			humidityarr = util.getHumidity (humidity);
			windspeed = util.getWindSpeed (windspeeddirection);
			winddirection = util.getWindDirection (windspeeddirection);	
			
			LoggerTrack.setInfo("Android_24HourPage launch ");
			
			return true;
			
		}else{
			LoggerTrack.setInfo("Fail launch Android_24HourPage  ");
			return false;
		}
		
	}
	
	public float getHighTemperature (){
	//High temperature 
		
		LoggerTrack.setInfo("getHighTemperature");
		return temperaturehi;
	
	}
	
	public float getLowTemperature (){
	//Low temperature 
		
		LoggerTrack.setInfo("getLowTemperature");
		return temperaturelo;
	
	}
	
	public int getHighWindSpeed (){
	//Wind speed 
		
		LoggerTrack.setInfo("getHighWindSpeed");
		return windspeed.get(1) ;
		
	}
	
	public int getLowWindSpeed (){
	//Low speed 
		
		LoggerTrack.setInfo("getLowWindSpeed");
		return windspeed.get(0) ;
		
	}
	
	public String getWindDirection(){
	//Wind direction
		
		LoggerTrack.setInfo("getWindDirection");
		return winddirection;
	}
	
	public int getHighHumidity (){
	//High humidity
		
		LoggerTrack.setInfo("getHighHumidity");
		return Integer.parseInt(humidityarr[0]) ;
		
	}
	
	public int getLowHumidity (){
	//Low humidity
		
		LoggerTrack.setInfo("getLowHumidity");
		return Integer.parseInt(humidityarr[1]) ;
		
	}
	
	
	

	
}

/*
 * 	Copyright (c) 2019 Ivan Tay All rights reserved
 * 
 *  String manipulation for mobile element texts
 * 
 */

package util;

import java.util.ArrayList;

public class StringBreaker {
/*
 * Break strings up from mobile element texts  
 */
	 private String windDirection;
	 
	 public String [] getHumidity(String text) {
	//Humidity string	 
		  
		  String regularexpression = "-";
		  return text.split(regularexpression);
		  
	  }
	  
	 public String getWindDirection (String textforecast){
	//Wind direction string	
		 
		 return windDirection;
		  
	  }
	  
	 public ArrayList<Integer> getWindSpeed (String textforecast){
	// Wind speed string
		 
		 ArrayList<Integer> windspeed = new ArrayList<Integer>();
		 String[] splited = textforecast.split("\\s+");
		 String regularexpression = "-";

		 windDirection= splited[0];
		  
		 String [] windSpeedString = splited[1].split(regularexpression,-2);
		 windspeed.add(Integer.parseInt(windSpeedString[0]));
		 windspeed.add(Integer.parseInt(windSpeedString[1]));
		  
		 return windspeed;
	  }
}

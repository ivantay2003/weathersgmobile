/*
 * 	Copyright (c) 2019 Ivan Tay All rights reserved
 * 
 *  Weather Forecast Rest API retrieval 
 * 
 */

package restapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherForecastSG24Hours {

	
	final private static String ROOT_URI = "https://api.data.gov.sg/v1/environment";
	final private static String PARAM = "24-hour-weather-forecast";
	
	private static Response response;
	private static RequestSpecification requestSpecification ; 
	private static int statusCode ;
	
	private static float temperaturelo, temperaturehi, relativehimidityhi,relativehimiditylo;
	private static int windspeedlo,windspeedhi;
	private static String winddirection, forecast;
	
	public WeatherForecastSG24Hours (){
		
		setInitialize();
	
	}
	
	
	public static void setInitialize (){
		
		RestAPIManager restAPIManager = new RestAPIManager (ROOT_URI, PARAM);
		response = restAPIManager.getResponse();
	
		statusCode = response.getStatusCode();
		if (response.getStatusCode()==200)
		getData();
		
	}
	public static int getStatusCode (){
		
		return statusCode;
	}
	
	private static void getData (){
		
		temperaturelo = response.body().jsonPath().getFloat("items[0].general.temperature.low");
		temperaturehi = response.body().jsonPath().getFloat("items[0].general.temperature.high");
		relativehimidityhi = response.body().jsonPath().getFloat("items[0].general.relative_humidity.high");
		relativehimiditylo = response.body().jsonPath().getFloat("items[0].general.relative_humidity.low");
		winddirection = response.body().jsonPath().getString("items[0].general.wind.direction");
		windspeedlo = response.body().jsonPath().getInt("items[0].general.wind.speed.low");
		windspeedhi = response.body().jsonPath().getInt("items[0].general.wind.speed.high");  
		forecast = response.body().jsonPath().getString("items[0].general.forecast");
	}
	
	public static float getLowTemperature (){
		
		return temperaturelo;
	}
	
	public static float getHighTemperature (){
		
		return temperaturehi;
	}
	
	public static float getHighHumidity (){
		
		return relativehimidityhi;
	}
	
	public static float getLowHumidity (){
		
		return relativehimiditylo;
	}
	
	public static String getWindDirection (){
		
		return winddirection;
	}
	
	public static int getLowWindSpeed (){
		
		return windspeedlo;
	}
	
	public static int getHighWindSpeed (){
		
		return windspeedhi;
	}
	
	public static String getForecast (){
		
		return forecast;
	}
	
}

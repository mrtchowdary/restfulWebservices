package de.qa.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_GET {
//	http://api.openweathermap.org/data/2.5/weather?q=visakhapatnam&appid=43b411d6f2697237d343d0d715b678ff
	@Test
	public void validatingStatus(){
		String key = "43b411d6f2697237d343d0d715b678ff";
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather?";
		
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.params("q", "visakhapatnam");
		request.param("appid", key);
		
		Response response = request.get();
		
		System.out.println(response.getBody().asString());
		
//		System.out.println(response.path("weather.description"));
		
		Assert.assertEquals(response.path("name").toString().toLowerCase().contains("visakhapatnam"), true);
		
//		Assert.assertEquals(response.getStatusCode(), 200);
		
//		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	}

}

package com.juaracoding.restassured.posttestduadua;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestHerokuPatch {
	
String endpoint = "https://mern-backend-8881.herokuapp.com/products";
	
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Zaenal");
		request.put("categoty", "Rest Assured");
		request.put("price", "2000");
		System.out.println(request.toJSONString());
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch(endpoint)
		.then()
		.statusCode(404)
		.log().all();
	}

}

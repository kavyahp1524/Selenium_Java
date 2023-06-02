package Trello;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.net.http.HttpResponse;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class trello {
	
	String id;
	
	@Test(enabled=true,priority = 0)
	public void Create_a_board() {
		
		RestAssured.baseURI="https://api.trello.com";
	    
		 Response re= given()
		             .queryParam("name", "kavya")
		             .queryParam("key", "c818364077a6d2e88dcae2441ec0a591")
		             .queryParam("token", "ATTA815f376b4ea52e4be8cc51e2dd8f8f121522b58792ff00812ecb2c955ffc5815260DD000")
		             .header("Content-Type","application/json")
		             .when().post("/1/boards").then().statusCode(200).extract().response();
		
		System.out.println(re.asString());
		
		JsonPath jp = new JsonPath(re.asString());
		id = jp.getString("id");
		
		System.out.println(id);
			
	}
	
	@Test(enabled=true,priority = 1)
	public void Get_a_board() {
		
		RestAssured.baseURI="https://api.trello.com";
		
		Response re = given()
	                 .queryParam("key", "c818364077a6d2e88dcae2441ec0a591")
	                 .queryParam("token", "ATTA815f376b4ea52e4be8cc51e2dd8f8f121522b58792ff00812ecb2c955ffc5815260DD000")
	                 .header("Content-Type", "application/json")
	                 .when().get(id).then().statusCode(200).extract().response();
			}
	
	@Test(enabled=true,priority = 2)
	public void Update_a_board() {
		
		RestAssured.baseURI = "https://api.trello.com";
		
		               given()
				      .queryParam("name","shreehp")
				      .queryParam("key","c818364077a6d2e88dcae2441ec0a591")
				      .queryParam("token", "ATTA815f376b4ea52e4be8cc51e2dd8f8f121522b58792ff00812ecb2c955ffc5815260DD000")
				      .header("Content-Type", "application/json")
				      .when().put("/1/boards/"+id).then().statusCode(200);
	}
	
	@Test(enabled=true,priority = 3)
	public void Delete_a_board() {
		
		RestAssured.baseURI="https://api.trello.com/1/boards/"+id;
		 given()
		.queryParam("key","c818364077a6d2e88dcae2441ec0a591")
		.queryParam("token", "ATTA815f376b4ea52e4be8cc51e2dd8f8f121522b58792ff00812ecb2c955ffc5815260DD000")
		.header("Content-Type","application/json")
		.when().delete().then().statusCode(200);
	}

}

package Upskill;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class API_request {
	
	String id;
		
	@Test
	public void Get_access_token() {
		given().header("Authorization","Basic","c2hvcHBpbmdfb2F1dGhfY2xpZW50OnNob3BwaW5nX29hdXRoX3NlY3JldA==")
		.post("http://rest-api.upskills.in/api/rest/oauth2/token/client_credentials").then().statusCode(200)
		.extract().response();
	}

}

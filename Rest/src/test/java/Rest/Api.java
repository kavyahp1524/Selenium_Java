package Rest;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Api {
	@Test
	public void method1(){
		Response res= RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody());
		System.out.println(res.asString());
		Assert.assertEquals(200, res.getStatusCode()); 
	}

}

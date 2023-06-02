package Rest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.net.http.HttpResponse;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class trello {
	String id;
	
@Test
public void creatboard() {
	
	RestAssured.baseURI="https://api.trello.com";
	
	Response re=  given()
	.queryParam("name","kav")
	.queryParam("key","2edce6357dccf29f5196de5da63e18ec")
	.queryParam("token", "ATTA38d004b604abbd76038ea24231c2ce5b0cd523399eea0199bb9a15238a815273437DCC1F")
	.header("Content-Type","application/json")
	.when().post("/1/boards").then().statusCode(200).extract().response();	
	
	System.out.println(re.asString());
	
	JsonPath jp=new JsonPath(re.asString());
	id = jp.getString("id");
	System.out.println(id);
	
}

//@Test
public void getboard() {
	RestAssured.baseURI="https://api.trello.com/1/boards"+id;
	given()
	.header("Accept", "application/json")
	.queryParam("key","2edce6357dccf29f5196de5da63e18ec")
	.queryParam("token", "ATTA38d004b604abbd76038ea24231c2ce5b0cd523399eea0199bb9a15238a815273437DCC1F")
	.header("Content-Type","application/json")
	.when().get().then().statusCode(404);
}

//@Test
public void updateboard() {
	RestAssured.baseURI="https://api.trello.com/1/boards"+id;
	given()
	.queryParam("key","2edce6357dccf29f5196de5da63e18ec")
	.queryParam("token", "ATTA38d004b604abbd76038ea24231c2ce5b0cd523399eea0199bb9a15238a815273437DCC1F")
	.header("Content-Type","application/json")
	.when().put("/1/boards"+id).then().statusCode(200);
}

@Test
public void deletboard() {
	 RestAssured.baseURI="https://api.trello.com/1/boards/"+id;
	 given()
	.queryParam("key","2edce6357dccf29f5196de5da63e18ec")
	.queryParam("token", "ATTA38d004b604abbd76038ea24231c2ce5b0cd523399eea0199bb9a15238a815273437DCC1F")
	.header("Content-Type","application/json")
	.when().delete().then().statusCode(200);
}
}
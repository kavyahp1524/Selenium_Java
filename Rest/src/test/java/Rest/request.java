package Rest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;

public class request {
	//@Test
	public void getmethod1(){
		//given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]",equalTo(7));

	}
//@Test
	public void Postmethod() {
	
	   HashMap<String, Object> obj=new HashMap<String, Object>();
	   obj.put("name"," morpheus");
	   obj.put("job"," morpheus");
	   JSONObject js=new JSONObject();
	   given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		
	}
	@Test
	public void putmethod() {
		 HashMap<String, Object> obj=new HashMap<String, Object>();
		   obj.put("name"," morpheus");
		   obj.put("job"," morpheus");
		   JSONObject js=new JSONObject();
		   given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		
	}
@Test
public void delet() {
	   given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
}

}

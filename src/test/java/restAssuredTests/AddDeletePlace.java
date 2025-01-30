package restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restAssuredUtilities.Payloads;



public class AddDeletePlace {
	SoftAssert sa;
	String addedplaceid;
	JsonPath js;
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		 sa = new SoftAssert();
	}
	
	@Test
	public void addPlace() {	
		
		
		String resp = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payloads.postPayload()).when().post("/maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200).body("status",equalTo("OK")).
				header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		js = new JsonPath(resp);
		String statuscode = js.get("status");
		sa.assertEquals(statuscode, "OK");
		addedplaceid = js.get("place_id");
		System.out.println("Place ID of new place is: "+ addedplaceid);
		sa.assertNotNull(addedplaceid);
		sa.assertAll();
	}
	@Test
	public void getPlace() {
		
	System.out.println("GET PLACE REQUEST");
	String getplaceresponse = 	given().queryParam("key", "qaclick123").queryParam("place_id", addedplaceid).when() 
		.get("maps/api/place/get/json").then() 
		.assertThat().statusCode(200).extract().response().asString();
	js = new JsonPath(getplaceresponse);
	String address = js.get("address");
	sa.assertEquals(address, "10900 H8");
	sa.assertAll();
	}
	
	@Test
	public void updatePlace() {
		System.out.println("PUT CALL REQUEST");
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", addedplaceid). 
		header("Content-Type","application/json")
		.body(Payloads.putPayload(addedplaceid)).when().put("/maps/api/place/update/json").then() 
				.assertThat().statusCode(200);
	}

}

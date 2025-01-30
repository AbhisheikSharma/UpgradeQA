package restAssuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class LibraryAPI {
	
	@BeforeClass
	public void setUp() {
	RestAssured.baseURI="http://216.10.245.166";
	}
	@Test(dataProvider="Books", dataProviderClass=restAssuredUtilities.DataProviders.class)
	public void addBook(String bookname, String authorname, String isbn) {
		given().header("Content-Type","application/json")
		.body("{\n"
				+ "\"name\":\""+bookname+"\",\n"
				+ "\"isbn\":\""+isbn+"\",\n"
				+ "\"aisle\":\"227\",\n"
				+ "\"author\":\""+authorname+"\"\n"
				+ "}\n"
				+ "")
		.when() 
		.post("Library/Addbook.php").then().log().all().assertThat().statusCode(200);
		
		
	}

}

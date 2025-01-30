package restAssuredTests;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import restAssuredUtilities.Payloads;

public class ComplexJsonParsing {
	public static void main(String[] args) {
		
		JsonPath js= new JsonPath(Payloads.getMockResponse());
		int num = js.getInt("courses.size()");
		System.out.println("number of courses "+num);
		int puramt = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase amt "+ puramt);
		String title = js.getString("courses[0].title");
		System.out.println("Title is " + title);
		
		for(int i=0;i<num;i++) {
			String ctitle = (js.get("courses["+i+"].title"));
			System.out.print(ctitle+"-->");
			if(ctitle.equals("RPA")) {
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println("RPA copies sold "+ copies);
				break;
			}
			int cprice = js.getInt("courses["+i+"].price");
			System.out.print(+cprice);
			System.out.println();
		}
		int total = 0;
		for(int i=0;i<num;i++) {
			total = total + ((js.getInt("courses["+i+"].price"))*(js.getInt("courses["+i+"].copies")));
		}
			System.out.println("total is "+ total);
			Assert.assertEquals(total, 910);
	}

}

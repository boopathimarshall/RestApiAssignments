package week4.day1.chaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchChangeRequest extends BaseClass{
	
	@Test(dependsOnMethods = {"week4.day1.chaining.PutChangeRequest.putChangerequest"})
	public void patchChangeRequest()
	{
		  resp = Request.when().body("{\r\n"
				+ "    \"short_description\": \"using patch method for hamcrest\",\r\n"
				+ "    \"description\": \"India\"\r\n"
				+ "}").patch("/change_request/"+sysId);
		
		resp.then().assertThat().statusCode(200);
		resp.then().assertThat().body("result.short_description", Matchers.containsString("hamcrest"));
		resp.then().assertThat().body("result.number",Matchers.equalTo(num));
	}

}

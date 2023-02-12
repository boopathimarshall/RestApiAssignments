package week4.day1.chaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PutChangeRequest extends BaseClass {
	
	@Test(dependsOnMethods = {"week4.day1.chaining.PostChangeRequest.postChangeReq"})
	public void putChangerequest() {
		 resp = Request.when().body("{\r\n"
				+ "    \"short_description\": \"using put method for hemcrest\",\r\n"
				+ "    \"description\": \"India\"\r\n"
				+ "}").put("/change_request/"+sysId);
		
		resp.then().assertThat().statusCode(200);
		resp.then().assertThat().body("result.short_description", Matchers.equalTo("using put method for hemcrest"));
	}

}

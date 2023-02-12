package week4.day1.chaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteChangeRequest extends BaseClass {
	
	@Test(dependsOnMethods = {"week4.day1.chaining.PatchChangeRequest.patchChangeRequest"})
	public void deleteChangeRequest()
	{
		 resp = Request.delete("/change_request/"+sysId);
		 resp.then().assertThat().statusCode(204).and().assertThat().statusLine(Matchers.equalTo("HTTP/1.1 204 No Content"));
		 
	}

}

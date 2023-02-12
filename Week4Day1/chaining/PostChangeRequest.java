package week4.day1.chaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PostChangeRequest extends BaseClass {

	@Test
	public void postChangeReq() {

		File file = new File("./src/test/resources/data/PostData.json");

		resp = Request.when().body(file).post("/change_request");
		resp.then().assertThat().statusCode(201);

		sysId = resp.jsonPath().get("result.sys_id");
		num = resp.jsonPath().get("result.number");

	}

}

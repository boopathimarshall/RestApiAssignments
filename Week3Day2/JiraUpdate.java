package week3.day2.jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class JiraUpdate {
	
	@Test
	public void updateTicket() {
		
		RestAssured.baseURI="https://boopathimarshallrest.atlassian.net";
		RestAssured.authentication = RestAssured.preemptive().basic("boopathimarshall@gmail.com", "ATATT3xFfGF08Zl8BN_dIgzBsGrRnZKKQE3Co3GF-jP2LSgdol_1Meam7M4rdrH9mnbk35cV8dpMWxoiMfNOicqxopwYZrM_B-FAIlvFL59c6vJvbddQpgB4VqaUzRqOzDvXMccEWyLLHRteyCT_4KrnCwiPnIFSjxhS3cMm3Cf38fQOZC-BoAQ=1291B5D8");
		RequestSpecification specification = RestAssured.given().contentType("application/json").accept("application/json")
		.when().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "\r\n"
				+ "        \"description\": \"Bug update Using REST API for testing\"\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "");
		
		 Response response = specification.put("/rest/api/2/issue/10033");
				 ValidatableResponse statusCode = response.then().assertThat().statusCode(204);
		System.out.println(response.prettyPrint());
	}

}

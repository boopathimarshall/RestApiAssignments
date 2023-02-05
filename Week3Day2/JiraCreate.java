package week3.day2.jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraCreate {
	
	public String id;
	
	@Test
	public void createTicket() {
		
		RestAssured.baseURI="https://boopathimarshallrest.atlassian.net";
		RestAssured.authentication = RestAssured.preemptive().basic("boopathimarshall@gmail.com", "ATATT3xFfGF08Zl8BN_dIgzBsGrRnZKKQE3Co3GF-jP2LSgdol_1Meam7M4rdrH9mnbk35cV8dpMWxoiMfNOicqxopwYZrM_B-FAIlvFL59c6vJvbddQpgB4VqaUzRqOzDvXMccEWyLLHRteyCT_4KrnCwiPnIFSjxhS3cMm3Cf38fQOZC-BoAQ=1291B5D8");
		RequestSpecification specification = RestAssured.given().contentType("application/json").accept("application/json")
		.when().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"TS\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"New issue from Postman\",\r\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the Postman\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}");
		
		Response post = specification.post("/rest/api/2/issue");
		post.then().assertThat().statusCode(201);
		System.out.println(post.prettyPrint());
		 id = post.jsonPath().get("id");
		System.out.println(id);
		
		
	}

}

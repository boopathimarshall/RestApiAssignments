package week3.day2.jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraUpdatedTicketDelete {

	@Test
	public void deleteTicket() {

		RestAssured.baseURI = "https://boopathimarshallrest.atlassian.net";
		RestAssured.authentication = RestAssured.preemptive().basic("boopathimarshall@gmail.com",
				"ATATT3xFfGF08Zl8BN_dIgzBsGrRnZKKQE3Co3GF-jP2LSgdol_1Meam7M4rdrH9mnbk35cV8dpMWxoiMfNOicqxopwYZrM_B-FAIlvFL59c6vJvbddQpgB4VqaUzRqOzDvXMccEWyLLHRteyCT_4KrnCwiPnIFSjxhS3cMm3Cf38fQOZC-BoAQ=1291B5D8");
		RequestSpecification specification = RestAssured.given();
		Response response = specification.delete("/rest/api/2/issue/10030");
		response.then().assertThat().statusCode(204);
	}
}
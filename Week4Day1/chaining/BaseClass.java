package week4.day1.chaining;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	static RequestSpecification Request;
	static Response resp;
	static String sysId;
	static String num;
	
	@BeforeMethod
	public void preConditions()
	{
		RestAssured.baseURI = "https://dev119496.service-now.com/api/now/table";
		RestAssured.authentication= RestAssured.basic("admin","gDsk4v@8A+GG");
		 Request = RestAssured.given().contentType("application/json").accept("application/json");
	}
	
	@AfterMethod
	public void postConditions() {
	 resp.then().log().all();
	}
}

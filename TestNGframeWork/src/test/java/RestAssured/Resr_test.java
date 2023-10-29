package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Resr_test {
  @Test
  public void f() {
	  baseURI="https://reqres.in";
	  String listUser_get_endpoint="/api/users?page=2";
 Response listUserResponse=  get(baseURI+listUser_get_endpoint);
 listUserResponse.prettyPrint();
 int lu_StatusCode= listUserResponse.getStatusCode();
 System.out.println(lu_StatusCode);
 String luResponseBodyString= listUserResponse.asString();
 //michael.lawson@reqres.in is it existing or not
 
 Assert.assertTrue(luResponseBodyString.toLowerCase().contains("michael.lawson@reqres.in"), "Micheal email api validation in Api response");
 SoftAssert softassert= new SoftAssert();
 softassert.assertTrue(luResponseBodyString.toLowerCase().contains("michael.lawson@reqres.in"), "Micheal email api validation in Api response");
 softassert.assertAll();
	  
  }
}

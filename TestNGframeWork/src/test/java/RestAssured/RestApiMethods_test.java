package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;

public class RestApiMethods_test {
  @Test
  public void getApi() {
	  baseURI="https://reqres.in";
	  String get_endpoint="/api/users?page=2";
 Response get_Response=  get(baseURI+get_endpoint);
 get_Response.prettyPrint();
 int StatusCode= get_Response.getStatusCode();
 System.out.println(StatusCode);
 if(StatusCode==200) {
		System.out.println("200 Status code is visible & test is passed.");
	}
	else {
		System.out.println("200 Status code is not visible & test is failed.");
	}
 //with hard assertion
 Assert.assertEquals(StatusCode, 200, "200 Status code is visible & test is passed.");
 String ResponseBodyinString= get_Response.asString();
 //michael.lawson@reqres.in is it existing or not
 
 //Assert.assertTrue(ResponseBodyinString.toLowerCase().contains("michael.lawson@reqres.in"), "Micheal email api validation in Api response");
 SoftAssert softassert= new SoftAssert();
 softassert.assertTrue(ResponseBodyinString.toLowerCase().contains("michael.lawson@reqres.in"), "Micheal email api validation in Api response");
 softassert.assertAll();
	  
  }
  @Test
  public void postApi() {
	  File postjson_path= new File("C:\\Users\\shanu\\git\\TestNGframeWork\\TestNGframeWork\\Json_Api\\post_api.json");
	  baseURI="https://reqres.in";
	String	post_endpont="/api/users";
Response post_responseBody=given().contentType(ContentType.JSON).body(postjson_path).post(baseURI+post_endpont);
post_responseBody.prettyPrint();
int status_code= post_responseBody.statusCode();
SoftAssert softassert= new SoftAssert();
softassert.assertEquals(status_code, 201, "verifiy Status code 201 is visible and test is passed");
softassert.assertAll();
String resposeBodyInString=post_responseBody.asString();
//softassert.assertEquals(resposeBodyInString, post_endpont, resposeBodyInString);
softassert.assertTrue(resposeBodyInString.toLowerCase().contains("morpheus")," morpheus name Api validation ");
softassert.assertAll();
  }
public void putApi() {
	  File putjson_path= new File("C:\\Users\\shanu\\git\\TestNGframeWork\\TestNGframeWork\\Json_Api\\put_api.json");
	  baseURI="https://reqres.in";
	String	put_endpont="/api/users/2";
Response put_responseBody=given().contentType(ContentType.JSON).body(putjson_path).put(baseURI+put_endpont);
put_responseBody.prettyPrint();
int status_code= put_responseBody.statusCode();
SoftAssert softassert= new SoftAssert();
softassert.assertEquals(status_code, 200, "verifiy Status code 201 is visible and test is passed");
softassert.assertAll();
String resposeBodyInString=put_responseBody.asString();
softassert.assertEquals(resposeBodyInString, put_endpont, resposeBodyInString);
softassert.assertTrue(resposeBodyInString.contains("zion resident"),"job Api validation");
softassert.assertAll();
  
  }
@Test
public void patchApi() {
	  File patchjson_path= new File("C:\\Users\\shanu\\git\\TestNGframeWork\\TestNGframeWork\\Json_Api\\patch_api.json");
	  baseURI="https://reqres.in";
	String	patch_endpont="/api/users/2";
Response patch_responseBody=given().contentType(ContentType.JSON).body(patchjson_path).patch(baseURI+patch_endpont);
patch_responseBody.prettyPrint();
int status_code= patch_responseBody.statusCode();
System.out.println(status_code);
SoftAssert softassert= new SoftAssert();
softassert.assertEquals(status_code, 200, "verifiy Status code 200 is visible and test is passed");
softassert.assertAll();
System.out.println("*****");
String resposeBodyInString=patch_responseBody.asString();

softassert.assertTrue(resposeBodyInString.contains("zion resident"),"job Api validation");
softassert.assertAll();

}
@Test
public void deleteApi() {
	File patchjson_path= new File("C:\\Users\\shanu\\git\\TestNGframeWork\\TestNGframeWork\\Json_Api\\patch_api.json");
	  baseURI="https://reqres.in";
	String	delete_endpont="/api/users/2";
Response delete_responseBody=given().contentType(ContentType.JSON).body(patchjson_path).delete(baseURI+delete_endpont);
delete_responseBody.prettyPrint();
int status_code= delete_responseBody.statusCode();
System.out.println(status_code);
SoftAssert softassert= new SoftAssert();
softassert.assertEquals(status_code, 204, "verifiy Status code 400 is visible and test is passed");
softassert.assertAll();
String resposeBodyInString=delete_responseBody.asString();

}
}
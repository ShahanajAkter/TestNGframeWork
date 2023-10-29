package RestAssured;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.Test;

public class Post {
  @Test
  public void f() {
	  
	  baseURI="https://reqres.in";
	  String listUser_get_endpoint="/api/users";
  }
}

package testcases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest {



 @Test
public void getUsers(){

     RestAssured.baseURI="https://reqres.in/api";
     RequestSpecification httpreq =RestAssured.given();
     Response response = httpreq.request(Method.GET, "/users/5");
     String responsebody = response.getBody().asString();

     System.out.println(responsebody);


     int statuscode = response.getStatusCode();
      System.out.println(statuscode);
     Assert.assertEquals(statuscode,200);
      String statusline = response.getStatusLine();
      System.out.println(statusline);
      Assert.assertEquals(statusline,"HTTP/1.1 200 OK");

}





}

package testcases;

import com.google.gson.JsonElement;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostCall {
    @Test
    public void postUsers() {

        RestAssured.baseURI = "https://reqres.in/api";
        RequestSpecification httpreq = RestAssured.given();
       // Response response = httpreq.request(Method.GET, "/users/5");
        //String responsebody = response.getBody().asString();


        //payload
        JSONObject requestParams= new JSONObject();
        requestParams.put("name","ExperAuto");
        requestParams.put("Job", "Engineer");

        httpreq.header("Content-Type","application/json");
        httpreq.body(requestParams.toJSONString());

        // response
        Response response = httpreq.request(Method.POST, "/users");
        String responseBody = response.getBody().asString();

        System.out.println(responseBody);
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        Assert.assertEquals(statuscode,201);




    }

}

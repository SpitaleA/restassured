package com.restassured.app;
import io.restassured.RestAssured;
import io.restassured.builder.*;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.*;
import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * Unit test for simple App.
 */
public class ApiTest 
{   //@Test
    public void pruebaApi(){
        // Precondiciones del REQUEST
        given().
            log().all().
        //Accion donde va a ir el REQUEST
        when().
            get("https://petstore.swagger.io/v2/pet/4").
        //Validaciones que debemos tener en cuenta del RESPONSE
        then().
            log().all().
            assertThat().
            statusCode(200);
    }

    //@Test
    public void postRequest() {
        JSONObject requestParams = new JSONObject();
        JSONObject tags = new JSONObject();
        JSONArray tagsArray = new JSONArray();
        JSONArray photoUrlsArray = new JSONArray();
        JSONObject category = new JSONObject();

        photoUrlsArray.add("string");

        tags.put("id", 0);
        tags.put("name", "string");

        tagsArray.add(tags);

        category.put("id", 0);
        category.put("name", "string");

        requestParams.put("id",0);
        requestParams.put("category", category);
        requestParams.put("name", "doggie");
        requestParams.put("photoUrls", photoUrlsArray);
        requestParams.put("tags", tagsArray);
        requestParams.put("status", "available");


        /*RestAssured.baseURI = "https://petstore.swagger.io/#/"; 
        RequestSpecification request = RestAssured.given();
        // Add a header stating the Request body is a JSON 
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request 
        request.body(requestParams.toJSONString()); // Post the request and check the response
        
        Response response = request.post("/pet"); */
        given().
            log().all().
            contentType("application/json").
            body(requestParams.toJSONString()).
        //Accion donde va a ir el REQUEST
        when().
            post("https://petstore.swagger.io/v2/pet").
        //Validaciones que debemos tener en cuenta del RESPONSE
        then().
            log().all().
            assertThat().
            statusCode(200);
    }
    //@Test
    public void findByStatus() {
        given().
            log().all().
            queryParam("status", "available").
        //Accion donde va a ir el REQUEST
        when().
            get("https://petstore.swagger.io/v2/pet/findByStatus").
        //Validaciones que debemos tener en cuenta del RESPONSE
        then().
            assertThat().
            statusCode(200);
    }
   // @Test
    public void findPetById() {
        String petIdToFind = "3";
        given().
            log().all().
        //Accion donde va a ir el REQUEST
        when().
            get("https://petstore.swagger.io/v2/pet/"+petIdToFind).
        //Validaciones que debemos tener en cuenta del RESPONSE
        then().
            log().all().
            assertThat().
            statusCode(200);
    }
    @Test
    public void updatePet() {
        JSONObject requestParams = new JSONObject();
        JSONObject tags = new JSONObject();
        JSONArray tagsArray = new JSONArray();
        JSONArray photoUrlsArray = new JSONArray();
        JSONObject category = new JSONObject();

        photoUrlsArray.add("string");

        tags.put("id", 0);
        tags.put("name", "string");

        tagsArray.add(tags);

        category.put("id", 0);
        category.put("name", "string");

        requestParams.put("id",2);
        requestParams.put("category", category);
        requestParams.put("name", "michi");
        requestParams.put("photoUrls", photoUrlsArray);
        requestParams.put("tags", tagsArray);
        requestParams.put("status", "available");


        /*RestAssured.baseURI = "https://petstore.swagger.io/#/"; 
        RequestSpecification request = RestAssured.given();
        // Add a header stating the Request body is a JSON 
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request 
        request.body(requestParams.toJSONString()); // Post the request and check the response
        
        Response response = request.post("/pet"); */
        given().
            log().all().
            contentType("application/json").
            body(requestParams.toJSONString()).
        //Accion donde va a ir el REQUEST
        when().
            put("https://petstore.swagger.io/v2/pet").
        //Validaciones que debemos tener en cuenta del RESPONSE
        then().
            log().all().
            assertThat().
            statusCode(200);
    }
}

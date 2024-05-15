package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;

import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test; // Import JUnit Test annotation
import org.testng.Assert;   //used to validate response status

public class BookAPITest {

    //@Test // Add JUnit Test annotation
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        // In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }

    //@Test
    public void GetWeatherDetailsCondensed()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        // Get the RequestSpecification of the request that is to be sent
        // to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Call RequestSpecification.get() method to get the response.
        // Make sure you specify the resource name.
        Response response = httpRequest.get("");

        // Response.asString method will directly return the content of the body
        // as String.
        System.out.println("Response Body is =>  " + response.asString());
    }


        //@Test
        public void GetBookDetails()
        {
            // Specify the base URL to the RESTful web service
            RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
            // Get the RequestSpecification of the request to be sent to the server
            RequestSpecification httpRequest = RestAssured.given();

            Response response = httpRequest.get("");

            // Get the status code of the request.
            //If request is successful, status code will be 200
            int statusCode = response.getStatusCode();
            String statusLine = response.getStatusLine();

            // Assert that correct status code is returned.
            Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/,
                    "Correct status code returned");
            Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK"
                    /*expected value*/, "Correct status code returned");

        }



    //@Test
    public void getPetTest() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "v2/pet/1");

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is " + statusCode);

        Headers header = response.getHeaders();
        System.out.println("Headers of the response body are " + header);

        ResponseBody body = response.getBody();
        body.prettyPrint();
        System.out.println("Response Body is " + body.asString());

    }

    //@Test
    public void getFindByStatusTest3() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "v2/pet/findByStatus?status=available");

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is " + statusCode);

        Headers header = response.getHeaders();
        System.out.println("Headers of the response body are " + header);

        ResponseBody body = response.getBody();
        body.prettyPrint();
        System.out.println("Response Body is " + body.asString());

    }

    //@Test
    public void postPetTest() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        String request = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type","application/json");

        Response response = httpRequest.body(request).post("/v2/pet");

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is "+statusCode);

    }

    //@Test
    public void postPetTest1() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type","application/json");

        Response response = httpRequest.post("/v2/pet/1");

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is "+statusCode);

    }

    //@Test
    public void deletePetTest() {

        RestAssured.baseURI = "https://petstore.swagger.io";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json").header("accept", "application/json");

        Response response = httpRequest.delete("/v2/pet/1");

        System.out.println(response);
        System.out.println("Response status code is " + response.getStatusCode());

    }

    //@Test
    public void putPetTest() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        String request = "\n" +
                "  \"id\": 1,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json").header("accept", "application/json");

        Response response = httpRequest.body(request).put("/v2/pet");

        System.out.println(response);
        System.out.println("Response status code is " + response.getStatusCode());

    }

}


package com.rambabu.ex05_put_request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Put_NONBDDStyle {
    // PUT

    // token, booking id - A

//      public void get_token(){ }
//    public void get_booking_id(){}

    @Description("Verify the PUT Request for the Restful Booker APIs")
    @Test
    public void test_put_non_bdd(){
        String token = "90418fd6410ca64";
        String bookingid = "1465";
        String payloadPUT= "{\n" +
                "    \"firstname\" : \"ram\",\n" +
                "    \"lastname\" : \"yadav\",\n" +
                "    \"totalprice\" : 143,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        //        requestSpecification.auth().basic("admin","password123");


        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();

       Response response = requestSpecification.when().put();


        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
}

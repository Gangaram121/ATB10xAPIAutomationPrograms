package com.rambabu.ex06_patch_request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class patch_NonBDDStyle {
    @Description("Verify the Patch Request for the Restful Booker APIs")
    @Test
    public void test_patch_non_bdd() {
        String token = "dcef70d3f88ecd3";
        String bookingid = "1465";

        String payloadPatch = "{\n" +
                "    \"firstname\" : \"Jathin\",\n" +
                "    \"lastname\" : \"yadav\"\n" +
                "}";


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payloadPatch).log().all();

        Response response = requestSpecification.when().patch();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
    }
}
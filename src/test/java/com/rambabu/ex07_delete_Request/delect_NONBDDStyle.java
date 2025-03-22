package com.rambabu.ex07_delete_Request;

import com.sun.org.apache.bcel.internal.classfile.Constant;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class delect_NONBDDStyle {
    @Description("Verify the delete Request for the Restful Booker APIs")
    @Test
    public void test_delete_non_bdd() {
        String token = "9cc9447e730afc3";
        String bookingid = "2258";


      RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.log().all();

      Response response = requestSpecification.when().delete();

       ValidatableResponse validatableResponse = response.then().log().all();

        // validatableResponse.statusCode(200);
        validatableResponse.statusCode(201);

    }
}

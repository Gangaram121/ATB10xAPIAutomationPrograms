package com.rambabu.ex03_Get_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_NonBDDStyle_Multiple_apis {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the GET Req Positive")
    @Test
    public void test_NonBDD_GET() {
        String pincode = "517002";

        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();


        vr = response.then().log().all().statusCode(200);

    }

    @Description("Verify the GET Req Negative : -9 Input")
    @Test
    public void testNonBDDGET_negative() {
        String pin_code = "-9";

        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pin_code);
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(404);

    }

}

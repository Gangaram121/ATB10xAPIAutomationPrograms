package com.rambabu.ex03_Get_Request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Multiple_APITesting2_GET_BDDStyle {
    @Test
    public void test_BDD_Get() {
        String pincode = "517002";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void test_GET_Req_NEGATIVE() {
        String pin_code = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }
}

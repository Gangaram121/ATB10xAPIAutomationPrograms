package com.rambabu.ex03_Get_Request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting1_GET_BDDStyle {

    @Test
    public void test_BDD_Get(){
        String pincode ="560016";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);


    }


}

package tests.RegRes_API;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    public void stert(){
        RestAssured.filters(new AllureRestAssured());
        RestAssured.baseURI = "https://reqres.in/api";
    }

}

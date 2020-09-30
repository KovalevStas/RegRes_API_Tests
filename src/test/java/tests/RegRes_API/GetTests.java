package tests.RegRes_API;

import io.restassured.response.ValidatableResponse;
import models.ListUsers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetTests extends TestBase{

    @Test
    void listUsersTest() {
        ListUsers listUsers = given()
                .when()
                .get("/users?page=2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(ListUsers.class);

        System.out.println(listUsers.toString());
    }

    @Test
    void singleUserTest() {
        ValidatableResponse body = given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", is(2));
    }
}

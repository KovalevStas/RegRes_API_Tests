package tests.RegRes_API;

import models.ListUsers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase{

    @Test
    void deleteUserTest() {
        given()
                .when()
                .delete("/users/2")
                .then()
                .log().body()
                .statusCode(204);
    }
}

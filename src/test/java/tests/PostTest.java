package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static utils.FileUtils.readStringFromFile;

public class PostTest extends TestBase {


    @Test
    void singleUserTest() {
        given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
            .when()
                .post("/users")
            .then()
                .log().body()
                .statusCode(201)
                .body("id", is(notNullValue()));
    }

    @Test
    void registerUserTest() {
        String data = readStringFromFile("src/test/resources/register_successful.json");
        given().
                contentType(ContentType.JSON)
                .body(data)
            .when()
                .post("/register")
            .then()
                .log().body()
                .statusCode(200)
                .body("id", is(notNullValue()));
    }
}

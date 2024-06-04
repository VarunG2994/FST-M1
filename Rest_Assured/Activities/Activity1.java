import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.TestRunner.PriorityWeight.priority;

public class Activity1 {

private String baseUrl= "https://petstore.swagger.io/v2/pet";

    @Test
    @Order(1)
    public void postTest(){
        String respondBody= """
                {
                  "id": 77232,
                  "name": "Riley",
                  "status": "alive"
                }
                """;
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(respondBody) // Add request body
                        .when().post(baseUrl); //

        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));



    }

    @Test
    @Order(2)
    public void getTest(){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .get(baseUrl + "/{petId}"); // Send GET request

        // Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));

    }

    @Test()
    @Order(3)
    public void deleteTest(){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .delete(baseUrl + "/{petId}"); // Send DELETE request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77232"));
    }

    }


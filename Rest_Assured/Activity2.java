import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Activity2 {
   private String baseUrl= "https://petstore.swagger.io/v2/user";

    @Test
    @Order(1)
    public void postTest() throws IOException {
        FileInputStream inputJSON = new FileInputStream("src/test/java/userinfo.json");
        // Read JSON file as String
        String reqBody = new String(inputJSON.readAllBytes());

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody) // Pass request body from file
                        .when().post(baseUrl);
        inputJSON.close();
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("6586607"));



    }

    @Test
    @Order(2)
    public void getTest(){
        File outputJSON = new File("src/test/java/userGETResponse.json");

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .pathParam("username", "Virat") // Pass request body from file
                        .when().get(baseUrl + "/{username}"); // Send POST request

        // Get response body
        String resBody = response.getBody().asPrettyString();

        try {
            // Create JSON file
            outputJSON.createNewFile();
            // Write response body to external file
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }

        // Assertion
        response.then().body("id", equalTo(6586607));
        response.then().body("username", equalTo("Virat"));
        response.then().body("firstName", equalTo("Justin"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));
    }


    @Test
    @Order(3)
    public void deleteTest(){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .pathParam("username", "justinc") // Add path parameter
                        .when().delete(baseUrl + "/{username}"); // Send POST request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("Virat"));
    }

}

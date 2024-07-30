import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredProject {
    RequestSpecification requestSpec;
    private String sshKey;
    private int id;


    @BeforeClass
    public void setUp(){
        String baseUrl= "https://api.github.com";
        String accessToken= "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";
        requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                // Set base URL
                .setBaseUri(baseUrl)
                // Build request specification
                .build();

        }

    @Test(priority=1)
    public void postRequest(){
        String reqBody= """
                
                 {
                     "title": "TestAPIKey",
                     "key": "sssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGIuNZZMV9q3/RXa72sfD1veiLfT8dPpk+0/IV4MWhik azureadvarung@IBM-PF32PTSV"
                 }
                 """;


        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post(); // Send POST request



        //response.then().spec(responseSpec);



    }

    @Test(priority=2)
    public void getRequest(int id, String name, String status) {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("petId", id) // Add path parameter
                .when().get("/{petId}"); // Send GET request

        // Print response
        System.out.println(response.asPrettyString());
        // Assertions
      //  response.then()
            //    .spec(responseSpec) // Use responseSpec
              //  .body("name", equalTo(name)); // Additional Assertion
    }


    @Test(priority=3)
    public void deleteRequest(int id, String name, String status) {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("petId", id) // Add path parameter
                .when().delete("/{petId}"); // Send GET request


        response.then().body("code", equalTo(200));
    }
}

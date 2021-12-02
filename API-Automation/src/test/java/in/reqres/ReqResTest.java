package in.reqres;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class ReqResTest {

    @Test
    public void postUserDetails() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Divya");
        userDetails.setJob("QA");

        Response resp = given().contentType(ContentType.JSON).body(userDetails).log().body().
                when().post("https://reqres.in/api/users").then().assertThat().
                statusCode(201).extract().response();

        System.out.println(resp.asPrettyString());
    }
}

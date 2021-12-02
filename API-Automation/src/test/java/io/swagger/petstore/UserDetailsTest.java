package io.swagger.petstore;

import com.tngtech.java.junit.dataprovider.DataProvider;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
//import static java.util.concurrent.TimeUnit.SECONDS;
//import static org.hamcrest.Matchers.hasKey;

public class UserDetailsTest extends BaseTest {


    //Test for post and create Single User
    @Test
    public void postUserDetails(){

        UserReqPayload sendData = new UserReqPayload(100, "singleuser", "single", "user", "singleuser@gmail.com", "singleuser", "1234567890", 1);
        UserRespPayload postResponse;
        postResponse = given()
                .spec(singleUserCreationSpec)
                .body(sendData).log().all()
                .when()
                .post()
                .as(UserRespPayload.class);

        postResponse.printResponse();
        Assert.assertEquals(200,postResponse.getCode());
    }

    //Get user details
    @Test
    public void getUserDetails(){
        Response userResponse =
                given().spec(singleUserCreationSpec).
                        pathParam("username","singleuser").log().all().
                        when().get("/{username}").then().assertThat().
                        statusCode(200).and().extract().response();

        System.out.println("Response received "+userResponse.asPrettyString());
    }
}

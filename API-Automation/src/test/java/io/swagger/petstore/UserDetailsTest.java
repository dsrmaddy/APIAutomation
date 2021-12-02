package io.swagger.petstore;

//import com.tngtech.java.junit.dataprovider.DataProvider;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
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

    //post method for multiple users array
    @Test
    public void postUserArrayDetails(){

        List<UserReqPayload> userArray = new ArrayList<>();

        UserReqPayload user1 = new UserReqPayload(101, "petuser1", "pet1", "user1", "petuser1@gmail.com", "petuser1", "1234567890", 1);
        UserReqPayload user2 = new UserReqPayload(102, "petuser2", "pet2", "user2", "petuser2@gmail.com", "petuser2", "1234567890", 1);
        UserReqPayload user3 = new UserReqPayload(103, "petuser3", "pet3", "user3", "petuser3@gmail.com", "petuser3", "1234567890", 0);

        userArray.add(user1);
        userArray.add(user2);
        userArray.add(user3);

        UserRespPayload postResponse;
        postResponse = given()
                .spec(userArrayCreationSpec)
                .body(userArray).log().all()
                .when()
                .post()
                .as(UserRespPayload.class);

        postResponse.printResponse();
        Assert.assertEquals(200,postResponse.getCode());
        Assert.assertEquals("unknown", postResponse.getType());
    }
}

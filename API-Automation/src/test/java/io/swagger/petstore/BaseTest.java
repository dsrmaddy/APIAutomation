package io.swagger.petstore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class BaseTest {
    protected static String baseURL = "https://petstore.swagger.io/v2";
    protected String urlCategory = "/user";

    protected static String singleUserCreationEndPoint = "/user";
    protected static String userArrayCreationEndPoint = "/user/createWithArray";

    protected static RequestSpecification singleUserCreationSpec;
    protected static RequestSpecification userArrayCreationSpec;

    @BeforeClass
    public static void setup(){
        RequestSpecBuilder createSingleUserReq = new RequestSpecBuilder();

        createSingleUserReq.setBaseUri(baseURL);
        createSingleUserReq.setBasePath(singleUserCreationEndPoint);
        createSingleUserReq.setContentType(ContentType.JSON);
        singleUserCreationSpec = createSingleUserReq.build();

        RequestSpecBuilder multipleUserReq = new RequestSpecBuilder();
        multipleUserReq.setBaseUri(baseURL);
        multipleUserReq.setBasePath(userArrayCreationEndPoint);
        multipleUserReq.setContentType(ContentType.JSON);

        userArrayCreationSpec = multipleUserReq.build();
    }
}

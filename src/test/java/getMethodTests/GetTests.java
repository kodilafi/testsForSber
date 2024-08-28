package getMethodTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utilCollection.constantForTests.URL;

public class GetTests {
    @Test
    public void GetListUsers() {
        Specifications.InstallSpecification(200);
        List<GetUserResponsePojo> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().jsonPath().getList("data", GetUserResponsePojo.class);

        Assertions.assertNotNull(users);
    }
    @Test
    public void GetSingleUser() {
        Specifications.InstallSpecification(200);
        GetUserResponsePojo user = given()
                .when()
                .get("api/users/2")
                .then().log().all()
                .extract().jsonPath().getObject("data", GetUserResponsePojo.class);

        Assertions.assertNotNull(user);
    }
    @Test
    public void GetSingleUserNotFound() {
        Specifications.InstallSpecification(404);
        GetUserResponsePojo user = given()
                .when()
                .get("api/users/23")
                .then().log().all()
                .extract().jsonPath().getObject("data", GetUserResponsePojo.class);

        Assertions.assertNull(user);
    }
    @Test
    public void GetResourceList() {
        Specifications.InstallSpecification(200);
        List<GetResourceRequestPojo> resources = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().jsonPath().getList("data", GetResourceRequestPojo.class);

        Assertions.assertNotNull(resources);
    }
    @Test
    public void GetSingleResource() {
        Specifications.InstallSpecification(200);
        GetResourceRequestPojo resource = given()
                .when()
                .get("api/unknown/2")
                .then().log().all()
                .extract().jsonPath().getObject("data", GetResourceRequestPojo.class);

        Assertions.assertNotNull(resource);
    }
    @Test
    public void GetSingleResourceNotFound() {
        Specifications.InstallSpecification(404);
        GetResourceRequestPojo resource = given()
                .when()
                .get("api/unknown/23")
                .then().log().all()
                .extract().jsonPath().getObject("data", GetResourceRequestPojo.class);

        Assertions.assertNull(resource);
    }
}

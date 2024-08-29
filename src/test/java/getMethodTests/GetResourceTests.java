package getMethodTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetResourceTests {
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

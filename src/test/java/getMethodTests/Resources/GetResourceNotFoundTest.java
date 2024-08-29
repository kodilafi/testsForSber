package getMethodTests.Resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class GetResourceNotFoundTest {
    GetResourceRequestPojo getResource;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(404);
        getResource = given()
                .when()
                .get("api/unknown/23")
                .then().log().all()
                .extract().jsonPath().getObject("data", GetResourceRequestPojo.class);
    }

    @Test
    public void getResource_notFound() {
        Assertions.assertNull(getResource);
    }
}

package getMethodTests.Resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class GetOnceResourceTests {
    GetResourceRequestPojo getResource;
    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(200);

        getResource = given()
                .when()
                .get("api/unknown/2")
                .then().log().all()
                .extract().jsonPath().getObject("data", GetResourceRequestPojo.class);
    }

    @Test
    public void getResource_assertNotNull() {
        Assertions.assertNotNull(getResource);
    }
}

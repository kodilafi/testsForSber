package getMethodTests.Resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetResourceListTest {
    List<GetResourceRequestPojo> resources;

    @BeforeEach
    public void SetUp () {
        Specifications.InstallSpecification(200);

        resources = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().jsonPath().getList("data", GetResourceRequestPojo.class);
    }

    @Test
    public void getListOfResource () {
        Assertions.assertNotNull(resources);
    }
}

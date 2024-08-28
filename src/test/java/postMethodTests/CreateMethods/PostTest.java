package postMethodTests.CreateMethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class PostTest {
    @Test
    public void CreateUser() {
        Specifications.InstallSpecification(201);

        CreateRequestPojo userBefore = new CreateRequestPojo("morpheus", "leader");

        CreateResponsePojo userAfter = given()
                .body(userBefore)
                .when()
                .post("/api/users")
                .then().log().all()
                .extract().as(CreateResponsePojo.class);

        Assertions.assertNotNull(userAfter);
    }
}

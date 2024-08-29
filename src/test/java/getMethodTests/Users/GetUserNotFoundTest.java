package getMethodTests.Users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class GetUserNotFoundTest {
    GetUserResponsePojo user;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(404);

        user = given()
                .when()
                .get("api/users/23")
                .then().log().all()
                .extract().jsonPath().getObject("data", GetUserResponsePojo.class);
    }

    @Test
    public void getSingleUserNotFound_assertNull() {
        Assertions.assertNull(user);
    }
}

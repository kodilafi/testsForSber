package getMethodTests.Users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class GetSingleUserTest {
    GetUserResponsePojo user;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(200);

        user = given()
                .when()
                .get("api/users/2")
                .then().log().all()
                .extract().jsonPath().getObject("data", GetUserResponsePojo.class);
    }

    @Test
    public void getSingleUser_assertNotNull() {
        Assertions.assertNotNull(user);
    }
}

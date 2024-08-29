package getMethodTests.Users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.util.List;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class GetUserListTest {
    private static final Logger logger =
            Logger.getLogger(GetUserResponsePojo.class.getName());
    List<GetUserResponsePojo> users;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(200);

        users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().jsonPath().getList("data", GetUserResponsePojo.class);
    }

    @Test
    public void getListUsers_assertNotNull() {
        Assertions.assertNotNull(users);
    }
}

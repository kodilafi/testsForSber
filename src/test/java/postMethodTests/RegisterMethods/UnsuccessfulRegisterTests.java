package postMethodTests.RegisterMethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPogo;
import postMethodTests.ErrorPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class UnsuccessfulRegisterTests {
    EnterPogo createUser;
    ErrorPojo error;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(400);

        createUser = new EnterPogo("sydney@fife", "");

        error = given()
                .body(createUser)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(ErrorPojo.class);
    }

    @Test
    public void postTest_assertNotNull () {
        Assertions.assertNotNull(error.getError());
    }

    @Test
    public void postTest_assertEquals () {
        Assertions.assertEquals("Missing password", error.getError());
    }
}

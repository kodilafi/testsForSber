package postMethodTests.LoginMethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPogo;
import postMethodTests.ErrorPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class UnsuccessfulLoginTest {
    EnterPogo loginUser;
    ErrorPojo error;

    @BeforeEach
    public void UnsuccessfulLoginUser() {
        Specifications.InstallSpecification(400);

        loginUser = new EnterPogo("peter@klaven", "");

        error = given()
                .body(loginUser)
                .when()
                .post("/api/login")
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

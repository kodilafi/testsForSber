package postMethodTests.LoginMethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPogo;
import postMethodTests.ErrorPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class SuccessfulLoginTests {
    EnterPogo user;
    SuccessLoginPojo login;

    @BeforeEach
    public void SuccessfulLoginUser() {
        Specifications.InstallSpecification(200);

        user = new EnterPogo("eve.holt@reqres.in", "cityslicka");

        login = given()
                .body(user)
                .when()
                .post("/api/login")
                .then().log().all()
                .extract().as(SuccessLoginPojo.class);
    }

    @Test
    public void postTest_assertNotNullToken() {
        Assertions.assertNotNull(login.getToken());
    }

    @Test
    public void postTest_assertEqualsToken() {
        String token = "QpwL5tke4Pnpja7X4";
        Assertions.assertEquals(token, login.getToken());
    }
}

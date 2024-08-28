package postMethodTests.LoginMethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPogo;
import postMethodTests.ErrorPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class LoginTests {
    @Test
    public void SuccessfulLoginUser() {
        Specifications.InstallSpecification(200);

        String token = "QpwL5tke4Pnpja7X4";

        EnterPogo user = new EnterPogo("eve.holt@reqres.in", "cityslicka");

        SuccessLoginPojo login = given()
                .body(user)
                .when()
                .post("/api/login")
                .then().log().all()
                .extract().as(SuccessLoginPojo.class);

        Assertions.assertNotNull(login.getToken());
        Assertions.assertEquals(token, login.getToken());
    }
    @Test
    public void UnsuccessfulLoginUser() {
        Specifications.InstallSpecification(400);

        EnterPogo user = new EnterPogo("peter@klaven", "");

        ErrorPojo login = given()
                .body(user)
                .when()
                .post("/api/login")
                .then().log().all()
                .extract().as(ErrorPojo.class);

        Assertions.assertNotNull(login.getError());
        Assertions.assertEquals("Missing password", login.getError());
    }
}

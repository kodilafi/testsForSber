package postMethodTests.RegisterMethods;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPogo;
import postMethodTests.ErrorPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class RegisterTests {
    @Test
    public void SuccessfulRegisterUser() {
        Specifications.InstallSpecification(200);

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        EnterPogo user = new EnterPogo("eve.holt@reqres.in", "pistol");

        SuccessRegisterPojo register = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(SuccessRegisterPojo.class);

        Assertions.assertNotNull(register.getId());
        Assertions.assertNotNull(register.getToken());
        Assertions.assertEquals(id, register.getId());
        Assertions.assertEquals(token, register.getToken());
    }
    @Test
    public void UnsuccessfulRegisterUser() {
        Specifications.InstallSpecification(400);

        EnterPogo user = new EnterPogo("sydney@fife", "");

        ErrorPojo result = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(ErrorPojo.class);

        Assertions.assertNotNull(result.getError());
        Assertions.assertEquals("Missing password", result.getError());
    }
}

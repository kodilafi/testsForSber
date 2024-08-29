package postMethodTests.RegisterMethods;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPogo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;

public class SuccessfulRegister {
    EnterPogo userBefore;
    SuccessRegisterPojo userAfter;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(200);

        userBefore = new EnterPogo("eve.holt@reqres.in", "pistol");

        userAfter = given()
                .contentType(ContentType.JSON)
                .body(userBefore)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(SuccessRegisterPojo.class);
    }

    @Test
    public void postTest_assertNotNullId() {
        Assertions.assertNotNull(userAfter.getId());
    }

    @Test
    public void postTest_assertNotNullToken() {
        Assertions.assertNotNull(userAfter.getToken());
    }

    @Test
    public void postTest_assertEqualsId() {
        Integer id = 4;
        Assertions.assertEquals(id, userAfter.getId());
    }

    @Test
    public void postTest_assertEqualsToken() {
        String token = "QpwL5tke4Pnpja7X4";
        Assertions.assertEquals(token, userAfter.getToken());
    }
}

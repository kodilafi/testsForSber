package postMethodTests.RegisterMethods;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.differenceField;
import static utilCollection.WriteLogger.showLoggerInformation;

public class SuccessfulRegisterTest {
    Response response;
    EnterPojo request;
    SuccessRegisterPojo userAfter;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(200);

        request = new EnterPojo("eve.holt@reqres.in", "pistol");
        response = given().body(request).when().post("/api/register");
        userAfter = response.then().extract().jsonPath().getObject("", SuccessRegisterPojo.class);
    }

    //Тест_1: на сравнение ожидаемого и создаваемого id.
    @Test
    public void postTest_assertEqualsId() {
        Assertions.assertNotNull(userAfter.getId());

        Integer id = 4;
        differenceField("id", id, userAfter.getId());
        showLoggerInformation("postTest_assertEqualsId", response);
    }

    //Тест_2: на сравнение ожидаемого и создаваемого токена.
    @Test
    public void postTest_assertEqualsToken() {
        Assertions.assertNotNull(userAfter.getToken());

        String token = "QpwL5tke4Pnpja7X4";
        differenceField("token", token, userAfter.getToken());
        showLoggerInformation("postTest_assertEqualsToken", response);
    }
}

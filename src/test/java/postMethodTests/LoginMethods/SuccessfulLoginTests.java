package postMethodTests.LoginMethods;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.differenceField;
import static utilCollection.WriteLogger.showLoggerInformation;

public class SuccessfulLoginTests {
    Response response;
    EnterPojo request;
    SuccessLoginPojo login;

    @BeforeEach
    public void SuccessfulLoginUser() {
        Specifications.InstallSpecification(200);

        request = new EnterPojo("eve.holt@reqres.in", "cityslicka");
        response = given().body(request).when().post("/api/login");
        login = response.then().extract().jsonPath().getObject("", SuccessLoginPojo.class);
    }

    //Тест_1: на сравнение ожидаемого и создаваемого токена.
    @Test
    public void postTest_assertEqualsToken() {
        Assertions.assertNotNull(login.getToken());

        String token = "QpwL5tke4Pnpja7X4";
        differenceField("token", token, login.getToken());
        showLoggerInformation("postTest_assertEqualsToken", response);
    }
}

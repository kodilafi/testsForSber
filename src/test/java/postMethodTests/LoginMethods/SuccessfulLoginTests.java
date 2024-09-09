package postMethodTests.LoginMethods;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.*;

public class SuccessfulLoginTests {
    public static final Logger logger = LogManager.getLogger(SuccessfulLoginTests.class);
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
        String token = "QpwL5tke4Pnpja7X4";

        logger.info(showLoggerInformation(response));
        Assertions.assertNotNull(login.getToken());
        Assertions.assertEquals(token, login.getToken());
        logger.info(differenceField("token", token, login.getToken()));
    }
}

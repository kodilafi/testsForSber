package postMethodTests.RegisterMethods;

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

public class SuccessfulRegisterTest {
    public static final Logger logger = LogManager.getLogger(SuccessfulRegisterTest.class);
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
        Integer id = 4;

        logger.info(showLoggerInformation(response));
        Assertions.assertNotNull(userAfter.getId());
        Assertions.assertEquals(id, userAfter.getId());
        logger.info(differenceField("id", id, userAfter.getId()));
    }

    //Тест_2: на сравнение ожидаемого и создаваемого токена.
    @Test
    public void postTest_assertEqualsToken() {
        String token = "QpwL5tke4Pnpja7X4";

        logger.info(showLoggerInformation(response));
        Assertions.assertNotNull(userAfter.getToken());
        Assertions.assertEquals(token, userAfter.getToken());
        logger.info(differenceField("token", token, userAfter.getToken()));
    }
}

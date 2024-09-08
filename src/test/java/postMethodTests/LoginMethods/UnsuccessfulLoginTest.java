package postMethodTests.LoginMethods;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPojo;
import postMethodTests.ErrorPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.*;

public class UnsuccessfulLoginTest {
    Logger logger;
    Response response;
    EnterPojo request;
    ErrorPojo error;

    @BeforeEach
    public void UnsuccessfulLoginUser() {
        logger = LogManager.getLogger(UnsuccessfulLoginTest.class);
        Specifications.InstallSpecification(400);

        request = new EnterPojo("peter@klaven", "");
        response = given().body(request).when().post("/api/login");
        error = response.then().extract().jsonPath().getObject("", ErrorPojo.class);
    }

    //Тест_1: на вывод сообщения об ошибке.
    @Test
    public void postTest_assertEquals () {
        logger.info(showLoggerInformation(response));
        Assertions.assertNotNull(error.getError());
        Assertions.assertEquals("Missing password", error.getError());
        logger.info(differenceField("message", "Missing password", error.getError()));
    }
}

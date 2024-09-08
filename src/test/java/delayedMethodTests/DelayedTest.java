package delayedMethodTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import static utilCollection.WriteLogger.showLoggerInformation;

public class DelayedTest {
    Logger logger;
    Response response;

    //Тест_1: на ожидание ответа.
    @Test
    public void delayedTest () {
        logger = LogManager.getLogger(DelayedTest.class);
        Specifications.InstallSpecification(200);

        response = RestAssured.given().when().get("/api/users?delay=3");

        logger.info(showLoggerInformation(response));

        Assertions.assertTrue(response.time() > 1000);
    }
}

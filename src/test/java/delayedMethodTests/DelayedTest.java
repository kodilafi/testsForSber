package delayedMethodTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import static utilCollection.WriteLogger.showLoggerInformation;

public class DelayedTest {
    Response response;

    //Тест_1: на ожидание ответа.
    @Test
    public void delayedTest () {
        Specifications.InstallSpecification(200);

        response = RestAssured.given().when().get("/api/users?delay=3");

        Assertions.assertTrue(response.time() > 1000);
        showLoggerInformation("delayedTest", response);
    }
}

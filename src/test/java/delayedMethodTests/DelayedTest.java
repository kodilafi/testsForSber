package delayedMethodTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import static utilCollection.WriteLogger.showLoggerInformation;

public class DelayedTest {
    Response response;

    @BeforeEach
    public void SetUp () {
        Specifications.InstallSpecification(200);
        response = RestAssured.given().when().get("/api/users?delay=3");
    }

    @Test
    public void delayedTest_waitingMore1Sec () {
        Assertions.assertTrue(response.time() > 1000);
        showLoggerInformation("delayedTest", response);
    }
}

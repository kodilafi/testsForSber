package postMethodTests.RegisterMethods;

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

public class UnsuccessfulRegisterTests {
    public static final Logger logger = LogManager.getLogger(UnsuccessfulRegisterTests.class);
    Response response;
    EnterPojo request;
    ErrorPojo error;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(400);

        request = new EnterPojo("sydney@fife", "");
        response = given().body(request).when().post("/api/register");
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

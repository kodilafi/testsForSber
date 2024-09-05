package postMethodTests.RegisterMethods;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postMethodTests.EnterPojo;
import postMethodTests.ErrorPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.differenceField;
import static utilCollection.WriteLogger.showLoggerInformation;

public class UnsuccessfulRegisterTests {
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
        Assertions.assertNotNull(error.getError());
        differenceField("message", "Missing password", error.getError());
        showLoggerInformation("postTest_assertEquals", response);
    }
}

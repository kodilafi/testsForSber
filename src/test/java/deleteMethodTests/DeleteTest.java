package deleteMethodTests;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import utilCollection.*;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.showLoggerInformation;

public class DeleteTest {
    public static final Logger logger = LogManager.getLogger(DeleteTest.class);
    Response response;

    //Тест_1: на удаление пользователя.
    @Test
    public void deleteUser_test() {
        Specifications.InstallSpecification(204);

        response = given().when().delete("api/users/2");

        logger.info(showLoggerInformation(response));
    }
}

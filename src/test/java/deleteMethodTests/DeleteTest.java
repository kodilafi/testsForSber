package deleteMethodTests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utilCollection.*;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.showLoggerInformation;

public class DeleteTest {
    Response response;

    //Тест_1: на удаление пользователя.
    @Test
    public void deleteUser_test() {
        Specifications.InstallSpecification(204);

        response = given().when().delete("api/users/2");

        showLoggerInformation("deleteTest", response);
    }
}

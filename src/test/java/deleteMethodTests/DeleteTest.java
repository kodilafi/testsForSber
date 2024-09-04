package deleteMethodTests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utilCollection.*;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.showLoggerInformation;

public class DeleteTest {
    @Test
    public void delete_user_test() {
        Specifications.InstallSpecification(204);

        Response response = given()
                .when()
                .delete("api/users/2");

        showLoggerInformation("deleteTest", response);
    }
}

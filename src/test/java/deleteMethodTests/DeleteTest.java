package deleteMethodTests;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilCollection.*;

import static io.restassured.RestAssured.given;

public class DeleteTest {
    @Test
    public void delete_user_test() {
        Specifications.InstallSpecification(204);

        ValidatableResponse deleteUser = given()
                .when()
                .delete("api/users/2")
                .then().log().all();

        System.out.println("hello");
    }
}

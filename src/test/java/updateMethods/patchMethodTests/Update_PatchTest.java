package updateMethods.patchMethodTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import postMethodTests.ErrorPojo;
import updateMethods.UpdateRequestPojo;
import updateMethods.UpdateResponsePojo;
import utilCollection.Specifications;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class Update_PatchTest {
    @Test
    public void update_user_test() {
        Specifications.InstallSpecification(200);

        UpdateResponsePojo userBefore = new UpdateResponsePojo("morpheus", "zion resident");

        UpdateRequestPojo userAfter = given()
                .body(userBefore)
                .when()
                .patch("/api/users/2")
                .then().log().all()
                .extract().as(UpdateRequestPojo.class);

        Assertions.assertNotNull(userAfter);
        Assertions.assertEquals(userBefore.getJob(), userAfter.getJob());
        Assertions.assertEquals(userBefore.getName(), userAfter.getName());
        Assertions.assertEquals(LocalDate.now().toString(), new SimpleDateFormat("yyyy-MM-dd").format(userAfter.getUpdatedAt()));
    }
}

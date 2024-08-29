package updateMethods.patchMethodTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    UpdateResponsePojo userBefore;
    UpdateRequestPojo userAfter;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(200);

        userBefore = new UpdateResponsePojo("morpheus", "zion resident");

        userAfter = given()
                .body(userBefore)
                .when()
                .patch("/api/users/2")
                .then().log().all()
                .extract().as(UpdateRequestPojo.class);
    }

    @Test
    public void patchTest_assertNotNull() {
        Assertions.assertNotNull(userAfter);
    }

    @Test
    public void patchTest_assertEqualsJob() {
        Assertions.assertEquals(userBefore.getJob(), userAfter.getJob());
    }

    @Test
    public void patchTest_assertEqualsName() {
        Assertions.assertEquals(userBefore.getName(), userAfter.getName());
    }

    @Test
    public void patchTest_assertEqualsDate() {
        Assertions.assertEquals(LocalDate.now().toString(), new SimpleDateFormat("yyyy-MM-dd").format(userAfter.getUpdatedAt()));
    }
}

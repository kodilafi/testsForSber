package updateMethods.putMethodTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import updateMethods.UpdateRequestPojo;
import updateMethods.UpdateResponsePojo;
import utilCollection.Specifications;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;

public class Update_PutTest {
    UpdateRequestPojo userAfter;
    UpdateResponsePojo userBefore;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(200);

        userBefore = new UpdateResponsePojo("morpheus", "zion resident");

        userAfter = given()
                .body(userBefore)
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().as(UpdateRequestPojo.class);
    }

    @Test
    public void putTest_assertNotNull() {
        Assertions.assertNotNull(userAfter);
    }

    @Test
    public void putTest_assertEqualsName() {
        Assertions.assertEquals(userBefore.getJob(), userAfter.getJob());
    }

    @Test
    public void putTest_assertEqualsJob() {
        Assertions.assertEquals(userBefore.getName(), userAfter.getName());
    }

    @Test
    public void putTest_assertEqualsData() {
        Assertions.assertEquals(LocalDate.now().toString(), new SimpleDateFormat("yyyy-MM-dd").format(userAfter.getUpdatedAt()));
    }
}

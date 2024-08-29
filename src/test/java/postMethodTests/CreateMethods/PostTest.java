package postMethodTests.CreateMethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;

public class PostTest {
    CreateRequestPojo userBefore;
    CreateResponsePojo userAfter;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(201);

        userBefore = new CreateRequestPojo("morpheus", "leader");

        userAfter = given()
                .body(userBefore)
                .when()
                .post("/api/users")
                .then().log().all()
                .extract().as(CreateResponsePojo.class);
    }

    @Test
    public void postTest_assertNotNullUser() {
        Assertions.assertNotNull(userAfter);
    }

    @Test
    public void postTest_assertEqualsName() {
        Assertions.assertEquals(userBefore.getName(), userAfter.getName());
    }

    @Test
    public void postTest_assertEqualsJob() {
        Assertions.assertEquals(userBefore.getJob(), userAfter.getJob());
    }

    @Test
    public void postTest_assertEqualsDate() {
        Assertions.assertEquals(LocalDate.now().toString(), new SimpleDateFormat("yyyy-MM-dd").format(userAfter.getCreatedAt()));
    }
}

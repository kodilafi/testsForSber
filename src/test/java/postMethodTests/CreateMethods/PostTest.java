package postMethodTests.CreateMethods;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.*;

public class PostTest {
    CreateRequestPojo userRequest;
    CreateResponsePojo userResponse;
    Response response;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(201);

        userRequest = new CreateRequestPojo("morpheus", "leader");

        response = given()
                .body(userRequest)
                .when()
                .post("/api/users");

        userResponse = response.then().extract().as(CreateResponsePojo.class);
    }

    @Test
    public void postTest_assertNotNullUser() {
        Assertions.assertNotNull(userResponse);
        showLoggerInformation("postTest_assertNotNullUser", response);
        notNull("userResponse", userResponse.equals(null));
    }

    @Test
    public void postTest_assertEqualsName() {
        Assertions.assertEquals(userRequest.getName(), userResponse.getName());
        showLoggerInformation("postTest_assertEqualsName", response);
        differenceField("Name", userRequest.getName(), userResponse.getName());
    }

    @Test
    public void postTest_assertEqualsJob() {
        Assertions.assertEquals(userRequest.getJob(), userResponse.getJob());
        showLoggerInformation("postTest_assertEqualsJob", response);
        differenceField("Job", userRequest.getJob(), userResponse.getJob());
    }

    @Test
    public void postTest_assertEqualsDate() {
        Assertions.assertEquals(LocalDate.now().toString(), new SimpleDateFormat("yyyy-MM-dd").format(userResponse.getCreatedAt()));
        showLoggerInformation("postTest_assertEqualsDate", response);
        differenceData("дата создания пользователя", userResponse.getCreatedAt());
    }
}

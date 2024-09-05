package postMethodTests.CreateMethods;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;
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
        response = given().body(userRequest).when().post("/api/users");
        userResponse = response.then().extract().as(CreateResponsePojo.class);
    }

    //Тест_1: на равенство null.
    @Test
    public void postTest_assertNotNullUser() {
        showLoggerInformation("postTest_assertNotNullUser", response);
        notNull("userResponse", userResponse);
    }

    //Тест_2: на сравнение поля Name.
    @Test
    public void postTest_assertEqualsName() {
        showLoggerInformation("postTest_assertEqualsName", response);
        differenceField("Name", userRequest.getName(), userResponse.getName());
    }

    //Тест_3: на сравнение поля Job.
    @Test
    public void postTest_assertEqualsJob() {
        showLoggerInformation("postTest_assertEqualsJob", response);
        differenceField("Job", userRequest.getJob(), userResponse.getJob());
    }

    //Тест_4: на сравнение актуальной даты и даты создания нового пользователя.
    @Test
    public void postTest_assertEqualsDate() {
        showLoggerInformation("postTest_assertEqualsDate", response);
        differenceData("дата создания пользователя", userResponse.getCreatedAt());
    }
}

package postMethodTests.CreateMethods;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.*;

public class PostTest {
    Logger logger;
    CreateRequestPojo userRequest;
    CreateResponsePojo userResponse;
    Response response;

    @BeforeEach
    public void SetUp() {
        logger = LogManager.getLogger(PostTest.class);
        Specifications.InstallSpecification(201);

        userRequest = new CreateRequestPojo("morpheus", "leader");
        response = given().body(userRequest).when().post("/api/users");
        userResponse = response.then().extract().as(CreateResponsePojo.class);
    }

    //Тест_1: на равенство null.
    @Test
    public void postTest_assertNotNullUser() {
        logger.info(showLoggerInformation(response));

        Assertions.assertNotNull(userResponse);
        logger.info(isNull("userResponse", userResponse));
    }

    //Тест_2: на сравнение поля Name.
    @Test
    public void postTest_assertEqualsName() {
        logger.info(showLoggerInformation(response));

        Assertions.assertEquals(userRequest.getName(), userResponse.getName());
        logger.info(differenceField("Name", userRequest.getName(), userResponse.getName()));
    }

    //Тест_3: на сравнение поля Job.
    @Test
    public void postTest_assertEqualsJob() {
        logger.info(showLoggerInformation(response));

        Assertions.assertEquals(userRequest.getJob(), userResponse.getJob());
        logger.info(differenceField("Job", userRequest.getJob(), userResponse.getJob()));
    }

    //Тест_4: на сравнение актуальной даты и даты создания нового пользователя.
    @Test
    public void postTest_assertEqualsDate() {
        logger.info(showLoggerInformation(response));

        Assertions.assertEquals(LocalDate.now().toString(), new SimpleDateFormat("yyyy-MM-dd").format(userResponse.getCreatedAt()));
        logger.info(differenceData("дата создания пользователя", userResponse.getCreatedAt()));
    }
}

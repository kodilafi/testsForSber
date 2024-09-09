package updateMethods.putMethodTests;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import updateMethods.UpdateRepsonsePojo;
import updateMethods.UpdateRequestPojo;
import utilCollection.Specifications;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.*;

public class Update_PutTest {
    public static final Logger logger = LogManager.getLogger(Update_PutTest.class);
    Response response;
    UpdateRequestPojo request;
    UpdateRepsonsePojo userAfter;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(200);

        request = new UpdateRequestPojo("morpheus", "zion resident");
        response = given().body(request).when().put("/api/users/2");
        userAfter = response.then().extract().jsonPath().getObject("", UpdateRepsonsePojo.class);

        logger.info(showLoggerInformation(response));
    }

    //Тест_1: на равенство ресурса null.
    @Test
    public void putTest_assertNotNull() {
        Assertions.assertNotNull(userAfter);
        logger.info(isNull("UpdateRequestPojo", userAfter));
    }

    //Тест_2: на сравнение поля Name в request и response.
    @Test
    public void putTest_assertEqualsName() {
        Assertions.assertEquals(request.getName(), userAfter.getName());
        logger.info(differenceField("Name", request.getName(), userAfter.getName()));
    }

    //Тест_3: на сравнение поля Job в request и response.
    @Test
    public void putTest_assertEqualsJob() {
        Assertions.assertEquals(request.getJob(), userAfter.getJob());
        logger.info(differenceField("Job", request.getJob(), userAfter.getJob()));
    }

    //Тест_4: на сравнение сегодняшней даты и даты обновления.
    @Test
    public void putTest_assertEqualsData() {
        Assertions.assertEquals(LocalDate.now().toString(), new SimpleDateFormat("yyyy-MM-dd").format(userAfter.getUpdatedAt()));
        logger.info(differenceData(userAfter.getUpdatedAt()));
    }
}

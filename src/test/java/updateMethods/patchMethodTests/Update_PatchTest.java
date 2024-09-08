package updateMethods.patchMethodTests;

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

public class Update_PatchTest {
    Logger logger;
    Response response;
    UpdateRequestPojo request;
    UpdateRepsonsePojo userAfter;

    @BeforeEach
    public void SetUp() {
        logger = LogManager.getLogger(Update_PatchTest.class);
        Specifications.InstallSpecification(200);

        request = new UpdateRequestPojo("morpheus", "zion resident");
        response = given().body(request).when().patch("/api/users/2");
        userAfter = response.then().extract().jsonPath().getObject("", UpdateRepsonsePojo.class);

        logger.info(showLoggerInformation(response));
    }

    //Тест_1: на равенство ресурса null.
    @Test
    public void patchTest_assertNotNull() {
        Assertions.assertNotNull(userAfter);
        logger.info(isNull("UpdateRequestPojo", userAfter));
    }

    //Тест_2: на сравнение поля Job в request и response.
    @Test
    public void patchTest_assertEqualsJob() {
        Assertions.assertEquals(request.getJob(), userAfter.getJob());
        logger.info(differenceField("Job", request.getJob(), userAfter.getJob()));
    }

    //Тест_3: на сравнение поля Name в request и response.
    @Test
    public void patchTest_assertEqualsName() {
        Assertions.assertEquals(request.getName(), userAfter.getName());
        logger.info(differenceField("Name", request.getName(), userAfter.getName()));
    }

    //Тест_4: на сравнение сегодняшней даты и даты обновления.
    @Test
    public void patchTest_assertEqualsDate() {
        Assertions.assertEquals(LocalDate.now().toString(), new SimpleDateFormat("yyyy-MM-dd").format(userAfter.getUpdatedAt()));
        logger.info(differenceData("дата обновления пользователя", userAfter.getUpdatedAt()));
    }
}

package updateMethods.patchMethodTests;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import updateMethods.UpdateRepsonsePojo;
import updateMethods.UpdateRequestPojo;
import utilCollection.Specifications;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.*;

public class Update_PatchTest {
    Response response;
    UpdateRequestPojo request;
    UpdateRepsonsePojo userAfter;

    @BeforeEach
    public void SetUp() {
        Specifications.InstallSpecification(200);

        request = new UpdateRequestPojo("morpheus", "zion resident");
        response = given().body(request).when().patch("/api/users/2");
        userAfter = response.then().extract().jsonPath().getObject("", UpdateRepsonsePojo.class);

        showLoggerInformation("putTest", response);
    }

    //Тест_1: на равенство ресурса null.
    @Test
    public void patchTest_assertNotNull() {
        notNull("UpdateRequestPojo", userAfter);
    }

    //Тест_2: на сравнение поля Job в request и response.
    @Test
    public void patchTest_assertEqualsJob() {
        differenceField("Job", request.getJob(), userAfter.getJob());
    }

    //Тест_3: на сравнение поля Name в request и response.
    @Test
    public void patchTest_assertEqualsName() {
        differenceField("Name", request.getJob(), userAfter.getJob());
    }

    //Тест_4: на сравнение сегодняшней даты и даты обновления.
    @Test
    public void patchTest_assertEqualsDate() {
        differenceData("дата обновления пользователя", userAfter.getUpdatedAt());
    }
}

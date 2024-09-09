package getMethodTests.Resources;

import getMethodTests.Users.GetUserTest;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.*;

public class GetResourceTest {
    public static final Logger logger = LogManager.getLogger(GetResourceTest.class);
    Response response;
    List<GetResourceRequestPojo> listOfResource;
    GetResourceRequestPojo singleResource;

    //Тест_1: на получение одного ресурса.
    @Test
    public void getSingleResource_assertNotNull () {
        Specifications.InstallSpecification(200);

        response = given().when().get("api/unknown/2");
        singleResource = response.then().extract().jsonPath().getObject("data", GetResourceRequestPojo.class);

        logger.info(showLoggerInformation(response));

        Assertions.assertNotNull(singleResource);
        logger.info(isNull("singleResource", singleResource));
    }

    //Тест_2: на получение списка ресурсов.
    @Test
    public void getListOfResource_assertNotNull () {
        Specifications.InstallSpecification(200);

        response = given().when().get("api/unknown");
        listOfResource = response.then().extract().jsonPath().getList("data", GetResourceRequestPojo.class);

        logger.info(showLoggerInformation(response));

        Assertions.assertNotNull(listOfResource);
        logger.info(isNull("listOfResource", listOfResource));
    }

    //Тест_3: на попытку получить несуществующий ресурс.
    @Test
    public void getNotFoundResource_assertNull () {
        Specifications.InstallSpecification(404);

        response = given().when().get("api/unknown/23");
        singleResource = response.then().extract().jsonPath().getObject("data", GetResourceRequestPojo.class);

        logger.info(showLoggerInformation(response));

        Assertions.assertNull(singleResource);
        logger.info(isNull("singleResource", singleResource));
    }
}

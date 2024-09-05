package getMethodTests.Resources;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.notNull;
import static utilCollection.WriteLogger.showLoggerInformation;

public class GetResourceTest {
    Response response;
    List<GetResourceRequestPojo> listOfResource;
    GetResourceRequestPojo singleResource;

    //Тест_1: на получение одного ресурса.
    @Test
    public void getSingleResource_assertNotNull () {
        getSingleResource();
        notNull("singleResource", singleResource);
    }

    //Тест_2: на получение списка ресурсов.
    @Test
    public void getListOfResource_assertNotNull () {
        getListOfResource();
        notNull("listOfResource", listOfResource);
    }

    //Тест_3: на попытку получить несуществующий ресурс.
    @Test
    public void getNotFoundResource_assertNull () {
        getNotFoundResource();
        notNull("singleResource", singleResource);
    }





    private void getSingleResource () {
        Specifications.InstallSpecification(200);

        response = given().when().get("api/unknown/2");
        singleResource = response.then().extract().jsonPath().getObject("data", GetResourceRequestPojo.class);

        showLoggerInformation("getSingleResource", response);
    }

    private void getListOfResource () {
        Specifications.InstallSpecification(200);

        response = given().when().get("api/unknown");
        listOfResource = response.then().extract().jsonPath().getList("data", GetResourceRequestPojo.class);

        showLoggerInformation("getListOfResource", response);
    }

    private void getNotFoundResource () {
        Specifications.InstallSpecification(404);

        response = given().when().get("api/unknown/23");
        singleResource = response.then().extract().jsonPath().getObject("data", GetResourceRequestPojo.class);

        showLoggerInformation("getNotFoundResource", response);
    }
}

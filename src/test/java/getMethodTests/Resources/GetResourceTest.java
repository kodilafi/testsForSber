package getMethodTests.Resources;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetResourceTest {
    Response response;
    List<GetResourceRequestPojo> listOfResource;
    GetResourceRequestPojo singleResource;

    //Тест_1: на получение одного ресурса.
    @Test
    public void getSingleResource_assertNotNull () {
        getSingleResource();
        Assertions.assertNotNull(singleResource);
    }

    //Тест_2: на получение списка ресурсов.
    @Test
    public void getListOfResource_assertNotNull () {
        getListOfResource();
        Assertions.assertNotNull(listOfResource);
    }

    //Тест_3: на попытку получить несуществующий ресурс.
    @Test
    public void getNotFoundResource_assertNull () {
        getNotFoundResource();
        Assertions.assertNull(singleResource);
    }





    private void getSingleResource () {
        Specifications.InstallSpecification(200);
        response = given().when().get("api/unknown/2");

        singleResource = response
                .then().log().all()
                .extract().jsonPath()
                .getObject("data", GetResourceRequestPojo.class);
    }

    private void getListOfResource () {
        Specifications.InstallSpecification(200);
        response = given().when().get("api/unknown");

        listOfResource = response
                .then().log().all()
                .extract().jsonPath()
                .getList("data", GetResourceRequestPojo.class);
    }

    private void getNotFoundResource () {
        Specifications.InstallSpecification(404);
        response = given().when().get("api/unknown/23");

        singleResource = response
                .then().log().all()
                .extract().jsonPath()
                .getObject("data", GetResourceRequestPojo.class);
    }
}

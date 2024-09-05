package getMethodTests.Users;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilCollection.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utilCollection.WriteLogger.*;

public class GetUserTest {
    Response response;
    List<GetUserResponsePojo> listOfUser;
    GetUserResponsePojo singleUser;

    //Тест_1: на получение одного пользователя.
    @Test
    public void getSingleUser_assertNotNull() {
        getSingleUser();
        notNull("singleUser", singleUser);
    }

    //Тест_2: на получение списка пользователей.
    @Test
    public void getListOfUser_assertNotNull() {
        getListOfUsers();
        notNull("listOfUser", listOfUser);
    }

    //Тест_3: на сравнение почты у всего списка пользователей с @reqres.in.
    @Test
    public void getListOfUser_assertEmail() {
        getListOfUsers();
        Assertions.assertTrue(listOfUser.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }

    //Тест_4: на попытку получить несуществующего пользователя.
    @Test
    public void getNotFoundUser_assertNull() {
        getNotFoundUser();
        notNull("singleUser", singleUser);
    }





    private void getSingleUser () {
        Specifications.InstallSpecification(200);

        response = given().when().get("api/users/2");
        singleUser = response.then().extract().jsonPath().getObject("data", GetUserResponsePojo.class);

        showLoggerInformation("getSingleUser", response);
    }

    private void getListOfUsers () {
        Specifications.InstallSpecification(200);

        response = given().when().get("api/users?page=2");
        listOfUser = response.then().extract().jsonPath().getList("data", GetUserResponsePojo.class);

        showLoggerInformation("getListOfUsers", response);
    }

    private void getNotFoundUser () {
        Specifications.InstallSpecification(404);

        response = given().when().get("api/users/23");
        singleUser = response.then().extract().jsonPath().getObject("data", GetUserResponsePojo.class);

        showLoggerInformation("getNotFoundUser", response);
    }
}

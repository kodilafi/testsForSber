package getMethodTests.Users;

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

public class GetUserTest {
    public static final Logger logger = LogManager.getLogger(GetUserTest.class);
    Response response;
    List<GetUserResponsePojo> listOfUser;
    GetUserResponsePojo singleUser;

    //Тест_1: на получение одного пользователя.
    @Test
    public void getSingleUser_assertNotNull() {
        Specifications.InstallSpecification(200);

        response = given().when().get("api/users/2");
        singleUser = response.then().extract().jsonPath().getObject("data", GetUserResponsePojo.class);

        logger.info(showLoggerInformation(response));

        Assertions.assertNotNull(singleUser);
        logger.info(isNull("singleUser", singleUser));
    }

    //Тест_2: на получение списка пользователей.
    @Test
    public void getListOfUser_assertNotNull() {
        Specifications.InstallSpecification(200);

        response = given().when().get("api/users?page=2");
        listOfUser = response.then().extract().jsonPath().getList("data", GetUserResponsePojo.class);

        logger.info(showLoggerInformation(response));

        Assertions.assertNotNull(listOfUser);
        logger.info(isNull("listOfUser", listOfUser));
    }

    //Тест_3: на сравнение почты у всего списка пользователей с @reqres.in.
    @Test
    public void getListOfUser_assertEmail() {
        Specifications.InstallSpecification(200);

        response = given().when().get("api/users?page=2");
        listOfUser = response.then().extract().jsonPath().getList("data", GetUserResponsePojo.class);

        logger.info(showLoggerInformation(response));
        Assertions.assertTrue(listOfUser.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }

    //Тест_4: на попытку получить несуществующего пользователя.
    @Test
    public void getNotFoundUser_assertNull() {
        Specifications.InstallSpecification(404);

        response = given().when().get("api/users/23");
        singleUser = response.then().extract().jsonPath().getObject("data", GetUserResponsePojo.class);

        logger.info(showLoggerInformation(response));

        Assertions.assertNull(singleUser);
        logger.info(isNull("singleUser", singleUser));
    }
}

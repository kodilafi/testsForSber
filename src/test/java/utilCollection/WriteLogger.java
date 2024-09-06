package utilCollection;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static utilCollection.ConstantForTests.*;

public class WriteLogger {
    public static void differenceField (String checkField, String except, String actual) {
        Assertions.assertEquals(except, actual);

        System.out.println("\nПоле '" + getCL_WHITE() + checkField + getCL_RESET()
                + "', введенное при создании: " + getCL_YELLOW() + except + getCL_RESET()
                + ", также '" + getCL_WHITE() + checkField + getCL_RESET() + "' отображаемое в созданном пользователе: "
                + getCL_YELLOW() + actual + getCL_RESET() + ".\n");
    }

    public static void differenceField (String checkField, int except, int actual) {
        Assertions.assertEquals(except, actual);

        System.out.println("\nПоле '" + getCL_WHITE() + checkField + getCL_RESET()
                + "', введенное при создании: " + getCL_YELLOW() + except + getCL_RESET()
                + ", также '" + getCL_WHITE() + checkField + getCL_RESET() + "' отображаемое в созданном пользователе: "
                + getCL_YELLOW() + actual + getCL_RESET() + ".\n");
    }

    public static void differenceData (String text, Date data) {
        Assertions.assertEquals(LocalDate.now().toString(), new SimpleDateFormat("yyyy-MM-dd").format(data));

        System.out.println("\nСегодняшняя дата: " + getCL_YELLOW() + LocalDate.now() + getCL_RESET() + ", "
                + getCL_WHITE() + text + getCL_RESET() + ": "
                + getCL_YELLOW() + new SimpleDateFormat("yyyy-MM-dd").format(data) + getCL_RESET() + ".\n");
    }

    public static void notNull (String text, Object object) {
        if (object == null) {
            System.out.println("\nОбъект '" + getCL_WHITE() + text + getCL_RESET() + "' равен null.\n");
            Assertions.assertNull(object);
        } else {
            System.out.println("\nОбъект '" + getCL_WHITE() + text + getCL_RESET() + "' не равен null.\n");
            Assertions.assertNotNull(object);
        }
    }

    public static void notNull (String text, List object) {
        if (object == null) {
            System.out.println("\nОбъект '" + getCL_WHITE() + text + getCL_RESET() + "' равен null.\n");
            Assertions.assertNull(object);
        } else {
            System.out.println("\nОбъект '" + getCL_WHITE() + text + getCL_RESET() + "' не равен null.\n");
            Assertions.assertNotNull(object);
        }
    }

    public static void showLoggerInformation (String testName, Response response) {
        System.out.println("\nНазвание теста: " + getCL_WHITE() + testName + getCL_RESET() + ".\n"
                + "Статус код: " + getCL_WHITE() + response.statusCode() + getCL_RESET() + ".\n"
                + "Время затраченное на получение ответа: " + getCL_YELLOW() + response.time() + getCL_RESET() + " ms.\n");
    }
}

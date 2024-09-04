package utilCollection;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static utilCollection.constantForTests.*;

public class WriteLogger {
    private static final Logger logger = LoggerFactory.getLogger(WriteLogger.class);

    public static void differenceField (String checkField, String except, String actual) {
        logger.info("\nПоле '" + CL_WHITE + checkField + CL_RESET
                + "', введенное при создании: " + CL_CYAN + except + CL_RESET
                + ", также '" + CL_WHITE + checkField + CL_RESET + "' отображаемое в созданном пользователе: "
                + CL_CYAN + actual + CL_RESET + ".\n\n");
    }

    public static void differenceData (String text, Date data) {
        logger.info("\nСегодняшняя дата: " + CL_CYAN + LocalDate.now() + CL_RESET + ", "
                + CL_WHITE + text + CL_RESET + ": "
                + CL_CYAN + new SimpleDateFormat("yyyy-MM-dd").format(data) + CL_RESET + ".\n\n");
    }

    public static void notNull (String text, boolean bool) {
        if (!bool) {
            logger.info("\nОбъект '" + CL_WHITE + text + CL_RESET + "' не равен null.\n\n");
        } else {
            logger.info("\nОбъект '" + CL_WHITE + text + CL_RESET + "' равен null.\n\n");
        }
    }

    public static void showLoggerInformation (String testName, Response response) {
        logger.info("\nНазвание теста: " + CL_WHITE + testName + CL_RESET + ".\n"
                + "Статус код: " + CL_WHITE + response.statusCode() + CL_RESET + ".\n"
                + "Время затраченное на получение ответа: " + CL_YELLOW + response.time() + CL_RESET + " ms.\n");
    }
}

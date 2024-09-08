package utilCollection;

import io.restassured.response.Response;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static utilCollection.ConstantForTests.*;

public class WriteLogger {
    public static String differenceField (String checkField, String except, String actual) {
        return "\nField '" + checkField
                + "', введенное при создании: " + except
                + ", также '" + checkField + "' отображаемое в созданном пользователе: "
                + actual + ".\n";
    }

    public static String differenceField (String checkField, int except, int actual) {
        return "\nField '" + checkField
                + "', введенное при создании: " + except
                + ", также '" + checkField + "' отображаемое в созданном пользователе: "
                + actual + ".\n";
    }

    public static String differenceData (String text, Date data) {
        return "\nСегодняшняя дата: " + LocalDate.now() + ", "
                + text + ": "
                + new SimpleDateFormat("yyyy-MM-dd").format(data) + ".\n";
    }

    public static String isNull(String text, Object object) {
        if (object == null) {
            return "\nObject '" + text + "' is null.\n";
        } else {
            return "\nObject '" + text + "' is not null.\n";
        }
    }

    public static String isNull(String text, List object) {
        if (object == null)
            return "\nObject '" + text + "' is null.\n";
        else
            return "\nObject '" + text + "' is not null.\n";
    }

    public static String showLoggerInformation (Response response) {
        return "\nStatus Code: " + response.statusCode() + ".\n"
                + "Time for Response: " + response.time() + " ms.\n";
    }
}

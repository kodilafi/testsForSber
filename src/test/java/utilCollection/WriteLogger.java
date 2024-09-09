package utilCollection;

import io.restassured.response.Response;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class WriteLogger {
    public static String differenceField (String checkField, String except, String actual) {
        StringBuilder res = new StringBuilder("Field '")
                .append(checkField)
                .append("', excepted: ")
                .append(except)
                .append(", and actual: ")
                .append(actual)
                .append(".\n");

        return res.toString();
    }

    public static String differenceField (String checkField, int except, int actual) {
        StringBuilder res = new StringBuilder("Field '")
                .append(checkField)
                .append("', excepted: ")
                .append(except)
                .append(", and actual: ")
                .append(actual)
                .append(".\n");

        return res.toString();
    }

    public static String differenceData (Date data) {
        StringBuilder res = new StringBuilder("Real date: ")
                .append(LocalDate.now())
                .append(", response Date : ")
                .append(new SimpleDateFormat("yyyy-MM-dd").format(data))
                .append(".\n");

        return res.toString();
    }

    public static String isNull(String text, Object object) {
        StringBuilder res = new StringBuilder("Object '")
                .append(text);

        if (object == null) {
            return res.append("' is null.\n").toString();
        } else {
            return res.append("' is not null.\n").toString();
        }
    }

    public static String isNull(String text, List list) {
        StringBuilder res = new StringBuilder("List '")
                .append(text);

        if (list == null) {
            return res.append("' is null.\n").toString();
        } else {
            return res.append("' is not null.\n").toString();
        }
    }

    public static String showLoggerInformation (Response response) {
        StringBuilder res = new StringBuilder("Status Code: ")
                .append(response.statusCode())
                .append(".\nTime for Response: ")
                .append(response.time())
                .append(" ms.\n");

        return res.toString();
    }

    private static String byteConvert (String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}

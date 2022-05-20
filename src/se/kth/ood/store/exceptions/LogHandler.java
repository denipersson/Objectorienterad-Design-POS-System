package se.kth.ood.store.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Represents error message display to developer
 */
public class LogHandler {

    /**
     * logs an error message to the developer
     * @param exception that caused the error
     */
    public void logErrorMessage(Exception exception){
        System.out.println("[LOG_DEVELOPER]");
        String message = createTime();
        message += ", Error: " + exception.getMessage() + " " + exception.getStackTrace().toString();
        System.out.println(message);
    }

    /**
     * sets the contents of a string to the current date and time
     * @return the string
     */
    private String createTime(){
        LocalDateTime currTime = LocalDateTime.now();
        return currTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}

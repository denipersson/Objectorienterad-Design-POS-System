package se.kth.ood.store.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Represents error message displayed to user
 */
public class ErrorMessageHandler {
    /**
     * Prints an error message to the user
     * @param errorMessage to print
     */
    public void printErrorMessage(String errorMessage){
        System.out.println("[LOG_USER]");
        String message = "Error: " + errorMessage;
        System.out.println(message);
    }
}

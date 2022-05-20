package se.kth.ood.store.exceptions;

/**
 * Exception class for the case where the server is not responding
 */
public class ServerErrorException extends RuntimeException{
    /**
     * Constructor for the exception
     */
    private boolean serverError = false;
    public ServerErrorException(){
        super("404 - The server is not responding.");
        serverError = true;
    }

    public boolean isServerError() {
        return serverError;
    }
}

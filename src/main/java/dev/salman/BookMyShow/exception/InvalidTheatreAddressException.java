package dev.salman.BookMyShow.exception;

public class InvalidTheatreAddressException extends RuntimeException{
    public InvalidTheatreAddressException() {
    }

    public InvalidTheatreAddressException(String message) {
        super(message);
    }

    public InvalidTheatreAddressException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTheatreAddressException(Throwable cause) {
        super(cause);
    }

    public InvalidTheatreAddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

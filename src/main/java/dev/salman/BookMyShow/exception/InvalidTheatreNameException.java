package dev.salman.BookMyShow.exception;

public class InvalidTheatreNameException extends RuntimeException{
    public InvalidTheatreNameException() {
    }

    public InvalidTheatreNameException(String message) {
        super(message);
    }

    public InvalidTheatreNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTheatreNameException(Throwable cause) {
        super(cause);
    }

    public InvalidTheatreNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package dev.salman.BookMyShow.exception;

public class InvalidCityException extends RuntimeException{
    public InvalidCityException() {
    }

    public InvalidCityException(String message) {
        super(message);
    }

    public InvalidCityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCityException(Throwable cause) {
        super(cause);
    }

    public InvalidCityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

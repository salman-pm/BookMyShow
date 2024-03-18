package dev.salman.BookMyShow.exception;

public class InvalidUserPasswordException extends RuntimeException{
    public InvalidUserPasswordException() {
    }

    public InvalidUserPasswordException(String message) {
        super(message);
    }

    public InvalidUserPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserPasswordException(Throwable cause) {
        super(cause);
    }

    public InvalidUserPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

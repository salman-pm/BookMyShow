package dev.salman.BookMyShow.exception;

public class InvalidUserEmailException extends RuntimeException{
    public InvalidUserEmailException() {
    }

    public InvalidUserEmailException(String message) {
        super(message);
    }

    public InvalidUserEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserEmailException(Throwable cause) {
        super(cause);
    }

    public InvalidUserEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

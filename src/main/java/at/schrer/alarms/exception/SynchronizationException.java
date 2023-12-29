package at.schrer.alarms.exception;

public class SynchronizationException extends Exception{
    public SynchronizationException() {
    }

    public SynchronizationException(String message) {
        super(message);
    }

    public SynchronizationException(String message, Throwable cause) {
        super(message, cause);
    }
}

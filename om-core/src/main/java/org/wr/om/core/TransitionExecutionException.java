package org.wr.om.core;

public class TransitionExecutionException extends RuntimeException {

    public TransitionExecutionException() {
    }

    public TransitionExecutionException(String message) {
        super(message);
    }

    public TransitionExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransitionExecutionException(Throwable cause) {
        super(cause);
    }

    public TransitionExecutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

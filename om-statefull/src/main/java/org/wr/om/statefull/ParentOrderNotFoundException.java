package org.wr.om.statefull;

public class ParentOrderNotFoundException extends RuntimeException {

    public ParentOrderNotFoundException() {
    }

    public ParentOrderNotFoundException(String message) {
        super(message);
    }

    public ParentOrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParentOrderNotFoundException(Throwable cause) {
        super(cause);
    }

    public ParentOrderNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

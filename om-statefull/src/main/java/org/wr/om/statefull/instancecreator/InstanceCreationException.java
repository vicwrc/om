package org.wr.om.statefull.instancecreator;

public class InstanceCreationException extends RuntimeException {

    public InstanceCreationException() {
    }

    public InstanceCreationException(String message) {
        super(message);
    }

    public InstanceCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstanceCreationException(Throwable cause) {
        super(cause);
    }

    public InstanceCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

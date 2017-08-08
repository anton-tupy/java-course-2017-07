package com;

public class DirectoryPrinterException extends Exception{
    public DirectoryPrinterException() {
    }

    public DirectoryPrinterException(String message) {
        super(message);
    }

    public DirectoryPrinterException(String message, Throwable cause) {
        super(message, cause);
    }

    public DirectoryPrinterException(Throwable cause) {
        super(cause);
    }


    public DirectoryPrinterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

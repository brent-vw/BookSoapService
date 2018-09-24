package com.realdolmen.brentvw.bookstore.domain.exception;

import javax.xml.ws.WebFault;

@WebFault(name = "cannotCreatePublisher")
public class InvalidPublisherException extends Exception {
    private CannotCreatePublisherFault faultInfo;

    public InvalidPublisherException() {}

    public InvalidPublisherException(String message, CannotCreatePublisherFault.Reason reason) {
        super(message);
        this.faultInfo = new CannotCreatePublisherFault(reason);
    }

    public CannotCreatePublisherFault getFaultInfo() {
        return faultInfo;
    }
}

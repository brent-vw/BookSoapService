package com.realdolmen.brentvw.bookstore.domain.exception;

public class CannotCreatePublisherFault {
    public enum Reason {
        MISSING_NAME, INVALID_ADDRESS
    }

    private Reason reason;

    public CannotCreatePublisherFault() {}
    public CannotCreatePublisherFault(Reason reason){
        this.reason = reason;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }
}

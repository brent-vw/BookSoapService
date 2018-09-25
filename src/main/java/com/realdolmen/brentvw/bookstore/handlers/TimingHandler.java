package com.realdolmen.brentvw.bookstore.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Collections;
import java.util.Set;

public class TimingHandler implements SOAPHandler<SOAPMessageContext> {
    private static final Logger LOG = LoggerFactory.getLogger(TimingHandler.class);

    private ThreadLocal<Long> start;

    public TimingHandler() {
        start = new ThreadLocal<>();
    }


    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isOutBound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(isOutBound) {
            try {
                LOG.info("Request {} took: {} ms.", context.getMessage().getSOAPBody().toString(), System.currentTimeMillis()  - start.get());
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        } else {
            start.set(System.currentTimeMillis());
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }
}

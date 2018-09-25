
package com.realdolmen.brentvw.bookstore.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.realdolmen.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OrderBook_QNAME = new QName("http://service.realdolmen.com/", "orderBook");
    private final static QName _OrderBookResponse_QNAME = new QName("http://service.realdolmen.com/", "orderBookResponse");
    private final static QName _Order_QNAME = new QName("http://service.realdolmen.com/", "order");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.realdolmen.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderBook }
     * 
     */
    public OrderBook createOrderBook() {
        return new OrderBook();
    }

    /**
     * Create an instance of {@link OrderBookResponse }
     * 
     */
    public OrderBookResponse createOrderBookResponse() {
        return new OrderBookResponse();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.realdolmen.com/", name = "orderBook")
    public JAXBElement<OrderBook> createOrderBook(OrderBook value) {
        return new JAXBElement<OrderBook>(_OrderBook_QNAME, OrderBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.realdolmen.com/", name = "orderBookResponse")
    public JAXBElement<OrderBookResponse> createOrderBookResponse(OrderBookResponse value) {
        return new JAXBElement<OrderBookResponse>(_OrderBookResponse_QNAME, OrderBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Order }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.realdolmen.com/", name = "order")
    public JAXBElement<Order> createOrder(Order value) {
        return new JAXBElement<Order>(_Order_QNAME, Order.class, null, value);
    }

}

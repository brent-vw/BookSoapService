package com.realdolmen.brentvw.bookstore.service;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "com.realdolmen.brentvw.bookstore.service.BookOrderService",
        wsdlLocation = "META-INF/orderbook.wsdl", portName = "BookOrderServicePort", serviceName = "BookOrderServiceImpl")
public class BookOrderServiceImpl implements BookOrderService {

    @Override
    public Order orderBook(int bookId) {
        Order order = new Order();
        order.setAmount(1550);
        order.setStatus("SENT");

        OrderBook orderBook = new OrderBook();
        orderBook.setBookId(bookId);

        return order;
    }
}

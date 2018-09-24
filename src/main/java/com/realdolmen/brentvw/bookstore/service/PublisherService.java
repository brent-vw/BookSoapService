package com.realdolmen.brentvw.bookstore.service;

import com.realdolmen.brentvw.bookstore.domain.Address;
import com.realdolmen.brentvw.bookstore.domain.Book;
import com.realdolmen.brentvw.bookstore.domain.Publisher;
import com.realdolmen.brentvw.bookstore.domain.exception.CannotCreatePublisherFault;
import com.realdolmen.brentvw.bookstore.domain.exception.InvalidPublisherException;
import com.realdolmen.brentvw.bookstore.repository.PublisherRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(serviceName = "BookService")
public class PublisherService {
    @Inject
    private PublisherRepository publisherRepository;

    @WebMethod(operationName = "Create")
    public void createPublisher(@WebParam(name = "publisher") Publisher publisher) throws InvalidPublisherException {
        if(publisher.getName() == null) {
            throw new InvalidPublisherException("The name is required", CannotCreatePublisherFault.Reason.MISSING_NAME);
        }

        if(publisher.getAddress() == null) {
            throw new InvalidPublisherException("The address is required", CannotCreatePublisherFault.Reason.INVALID_ADDRESS);
        }
        publisherRepository.createPublisher(publisher);
    }

    @WebMethod(operationName = "QuerySingle")
    public @WebResult(name = "publisher") Publisher getPublisherById(@WebParam(name = "pk") Integer id) {
        return publisherRepository.getPublisherById(id);
    }

    @WebMethod(operationName = "QueryAll")
    public @WebResult(name = "publishers") List<Publisher> findAllPublishers() {
        return publisherRepository.findAllPublishers();
    }

    @WebMethod(operationName = "QueryBooksByPublisher")
    public @WebResult(name = "books") List<Book> findBooksByPublisher(@WebParam(name = "name") String name, @WebParam(name = "address") Address address) {
        return publisherRepository.findBooksByPublisher(name, address);
    }

    @WebMethod
    public void addBook(@WebParam(name = "publisher") Integer publisherId, @WebParam(name = "book") Integer bookId) {
        publisherRepository.addBook(publisherId, bookId);
    }
}

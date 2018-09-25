package com.realdolmen.brentvw.bookstore.service;

import com.realdolmen.brentvw.bookstore.domain.Book;
import com.realdolmen.brentvw.bookstore.repository.BookRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.*;
import java.util.List;

@Stateless
@WebService(serviceName = "BookService")
@HandlerChain(file = "handlers.xml")
public class BookService {
    @Inject
    private BookRepository bookRepository;

    @WebMethod
    public @WebResult(name = "book") Book findBookById(@WebParam(name = "pk") Integer id) {
        return bookRepository.findBookById(id);
    }

    @WebMethod
    public @WebResult(name = "books") List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @WebMethod
    public void createBook(@WebParam(name = "book") Book book) {
        bookRepository.createBook(book);
    }

    @WebMethod
    public void deleteBook(@WebParam(name = "pk") Integer id) {
        bookRepository.deleteBook(id);
    }

    @WebMethod
    public void updateBook(@WebParam(name = "book") Book book) {
        bookRepository.updateBook(book);
    }
}

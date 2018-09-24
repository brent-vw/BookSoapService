package com.realdolmen.brentvw.bookstore.repository;

import com.realdolmen.brentvw.bookstore.domain.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Named
public class BookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Book findBookById(Integer id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAllBooks() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public void createBook(Book book) {
        entityManager.persist(book);
    }

    public void deleteBook(Integer id) {
        entityManager.remove(findBookById(id));
    }

    public void updateBook(Book book) {
        entityManager.merge(book);
    }
}

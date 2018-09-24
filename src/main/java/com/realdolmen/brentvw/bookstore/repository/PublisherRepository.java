package com.realdolmen.brentvw.bookstore.repository;

import com.realdolmen.brentvw.bookstore.domain.Address;
import com.realdolmen.brentvw.bookstore.domain.Book;
import com.realdolmen.brentvw.bookstore.domain.Publisher;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Named
public class PublisherRepository {
    @PersistenceContext
    private EntityManager em;

    @Inject
    BookRepository bookRepository;

    public void createPublisher(Publisher publisher) {
        em.persist(publisher);
    }

    public Publisher getPublisherById(Integer id) {
        return em.find(Publisher.class, id);
    }

    public List<Publisher> findAllPublishers() {
        return em.createQuery("select p from Publisher p", Publisher.class).getResultList();
    }

    public List<Book> findBooksByPublisher(String name, Address address) {
        Publisher publisher = em.createQuery("select p from Publisher p where p.name = :name", Publisher.class)
                .setParameter("name", name)
                .getSingleResult();

        if(publisher==null) {
            return null;
        }

        return new ArrayList<>(publisher.getBooks());
    }

    public void addBook(Integer publisherId, Integer bookId) {
        Publisher publisher = getPublisherById(publisherId);
        Book book = bookRepository.findBookById(bookId);

        if(book == null || publisher == null) {
            return;
        }

        publisher.getBooks().add(book);
        em.merge(book);
    }
}

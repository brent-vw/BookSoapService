package com.realdolmen.brentvw.bookstore.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@XmlRootElement
@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private Integer id;

    @Embedded
    private Address address;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> books;

    public Integer getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

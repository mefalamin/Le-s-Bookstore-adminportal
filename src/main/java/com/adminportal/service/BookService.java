package com.adminportal.service;

import com.adminportal.domain.Book;

import java.util.List;

/**
 * created by saikat on 4/13/19
 */
public interface BookService  {
    Book save(Book book);
    List<Book> findAll();
}

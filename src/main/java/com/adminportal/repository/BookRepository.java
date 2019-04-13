package com.adminportal.repository;

import com.adminportal.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * created by saikat on 4/13/19
 */
public interface BookRepository extends CrudRepository<Book,Long> {

     Book save(Book book);
}

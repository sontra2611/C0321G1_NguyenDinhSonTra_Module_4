package com.codegym.model.service;

import com.codegym.model.bean.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);
}

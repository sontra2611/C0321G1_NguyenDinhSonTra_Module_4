package com.codegym.model.service;

import com.codegym.model.bean.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void delete(Integer id);

    List<Blog> findByName(String name);
}

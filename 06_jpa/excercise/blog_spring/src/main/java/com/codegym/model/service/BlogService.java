package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.delete(findById(id));
    }

    @Override
    public List<Blog> findByName(String name) {
        return iBlogRepository.findByNameContains(name);
    }
}

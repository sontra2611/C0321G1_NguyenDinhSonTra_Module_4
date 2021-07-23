package com.codegym.model.service.blog;

import com.codegym.model.bean.Blog;
import com.codegym.model.repository.blog.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
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
    public Page<Blog> findAllByNameContrains(String name, Pageable pageable) {
        return iBlogRepository.findAllByNameContains(name, pageable);
    }
}

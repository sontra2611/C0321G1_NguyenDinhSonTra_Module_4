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
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findAllByCategory_Id(Integer id) {
        return iBlogRepository.findAllByCategory_Id(id);
    }
}

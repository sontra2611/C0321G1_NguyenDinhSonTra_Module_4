package com.codegym.model.service.blog;

import com.codegym.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Optional<Blog> findById(Integer id);

    List<Blog> findAllByCategory_Id(Integer id);
}

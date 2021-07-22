package com.codegym.model.repository.blog;

import com.codegym.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByNameContains(String name);
}
package com.codegym.model.repository.category;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}

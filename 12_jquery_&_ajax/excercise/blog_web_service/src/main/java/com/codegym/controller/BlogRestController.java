package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/blog")
public class BlogRestController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> getListBlog(@PageableDefault(value = 2) Pageable pageable, @RequestParam String searchName) {
        Page<Blog> blogList = null;
        String nameValue = "";
        if (!searchName.isEmpty()) {
            nameValue = searchName;
        }
        blogList = iBlogService.findByName(pageable, nameValue);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}

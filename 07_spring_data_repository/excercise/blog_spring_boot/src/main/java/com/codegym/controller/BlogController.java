package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import com.codegym.model.service.blog.IBlogService;
import com.codegym.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public String list(@PageableDefault(value = 5, sort = "createStartTime")Pageable pageable, Model model) {
        Page<Blog> blogList = iBlogService.findAll(pageable);
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryList);
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date(System.currentTimeMillis()));
        blog.setCreateStartTime(time);
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msgSuccess", "Added new blog have successfully");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msgSuccess", "Added new blog have successfully");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        iBlogService.delete(blog.getId());
        redirect.addFlashAttribute("msgSuccess", "Removed blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name,Pageable pageable, Model model) {
        Page<Blog> blogList = iBlogService.findAllByNameContrains(name,pageable);
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @PostMapping("/searchByIdCategory")
    public String searchBlogByIdCategory(@RequestParam Integer idCategory,Pageable pageable, Model model) {
        Page<Blog> blogList = iBlogService.findAllByCategoryId(idCategory, pageable);
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }
}

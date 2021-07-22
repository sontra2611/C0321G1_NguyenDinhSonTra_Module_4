package com.codegym.model.bean;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String content;
    private LocalDateTime createStartTime;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String name, String content, LocalDateTime createStartTime, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createStartTime = createStartTime;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(LocalDateTime createStartTime) {
        this.createStartTime = createStartTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

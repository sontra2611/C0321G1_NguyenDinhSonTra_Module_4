package com.codegym.model.repository;

import com.codegym.model.bean.Dictionary;

import java.util.List;

public interface DictionaryRepository {
    public List<Dictionary> findAll();
}

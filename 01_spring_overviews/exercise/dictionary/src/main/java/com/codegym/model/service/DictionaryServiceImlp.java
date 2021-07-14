package com.codegym.model.service;

import com.codegym.model.bean.Dictionary;
import com.codegym.model.repository.DictionaryRepository;
import com.codegym.model.repository.DictionaryRepositoryImlp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImlp implements DictionaryService {
    @Autowired
    DictionaryRepository repository;

    @Override
    public List<Dictionary> findAll() {
        return repository.findAll();
    }
}

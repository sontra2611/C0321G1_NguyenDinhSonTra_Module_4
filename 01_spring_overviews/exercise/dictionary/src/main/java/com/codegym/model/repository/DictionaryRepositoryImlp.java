package com.codegym.model.repository;

import com.codegym.model.bean.Dictionary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DictionaryRepositoryImlp implements DictionaryRepository {
    private static Map<Integer, Dictionary> dictionaries = new HashMap<>();

    static {
        dictionaries.put(1, new Dictionary("hello", "Xin chào"));
        dictionaries.put(2, new Dictionary("book", "Sách"));
        dictionaries.put(3, new Dictionary("dictionary", "Thư Viện"));
    }

    @Override
    public List<Dictionary> findAll() {
        return new ArrayList<>(dictionaries.values());
    }
}

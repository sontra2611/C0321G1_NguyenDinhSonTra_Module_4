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
    public String translate(String eng) {
        List<Dictionary> dictionaryList = repository.findAll();
        String result = null;
        for (int i = 0; i < dictionaryList.size(); i++){
            if ((eng.toLowerCase()).equals(dictionaryList.get(i).getEnglish())){
                result = dictionaryList.get(i).getVietnamese();
                return result;
            }
        }
        return result;
    }
}

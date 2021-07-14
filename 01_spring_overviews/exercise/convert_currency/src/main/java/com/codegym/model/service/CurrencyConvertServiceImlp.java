package com.codegym.model.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConvertServiceImlp implements CurrencyConvertService {
    @Override
    public float convert(String usd, String rate) {
        return Float.parseFloat(usd) * Float.parseFloat(rate);
    }
}

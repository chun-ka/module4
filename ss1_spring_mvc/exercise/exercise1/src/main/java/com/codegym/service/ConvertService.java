package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService {
    public double convert(double usd) {
        double vnd = usd * 22000;
        return vnd;
    }
}

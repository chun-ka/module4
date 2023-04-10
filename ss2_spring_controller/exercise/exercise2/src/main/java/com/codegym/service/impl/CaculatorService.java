package com.codegym.service.impl;

import com.codegym.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public String caculator(int number1, int number2, Character calculate) {
        int caculator=0;
        String result = "Lỗi";

        switch (calculate) {
            case '+':
                caculator = number1 + number2;
                break;
            case '-':
                caculator = number1 - number2;
                break;
            case '*':
                caculator = number1 * number2;
                break;
            case '/':
                try {
                    caculator = number1 / number2;
                    break;
                } catch (Exception e) {
                    return result;
                }
        }
        result = String.valueOf(caculator);
        return result;
    }
}

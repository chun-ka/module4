package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String,String> map = new TreeMap<>();
    static {
        map.put("one","một");
        map.put("two","hai");
        map.put("three","ba");
    }
    @Override
    public String translate(String string) {
       String word=map.get(string);
       String mess="không tìm thấy";
       if (word==null){
           return mess;
       }
       return word;
    }
}

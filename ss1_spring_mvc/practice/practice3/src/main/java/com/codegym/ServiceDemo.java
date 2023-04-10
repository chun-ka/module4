package com.codegym;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class ServiceDemo {
    private static Map<String,String> map=new TreeMap<>();
    static {
        map.put("one","một");
        map.put("two","hai");
        map.put("three","ba");
    }
    public String convert(String key){
       String value=map.get(key);
       String mess="không tồn tại";
       if (value==null){
           return mess;
       }
       return value;
    }
}

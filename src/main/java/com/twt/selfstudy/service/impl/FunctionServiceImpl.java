package com.twt.selfstudy.service.impl;

import com.twt.selfstudy.service.FunctionService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class FunctionServiceImpl implements FunctionService {
    @Override
    public  boolean checkObjFieldIsNull(Object obj) throws IllegalAccessException {
        boolean flag = true;
        for(Field f : obj.getClass().getDeclaredFields()){
            f.setAccessible(true);
            if(f.get(obj) != null){
                flag = false;
                break;
            }
        }
        return flag;
    }
}

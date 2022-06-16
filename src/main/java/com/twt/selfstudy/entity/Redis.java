package com.twt.selfstudy.entity;

import java.util.HashMap;
import java.util.Map;

public class Redis {

    private static final Map<String,String> redis = new HashMap<>();

    public static void setKeyValue(String key,String value){
        if (!(key.isEmpty() || value.isEmpty())) {
            redis.put(key,value);
        }
    }

    public static void clearRedis(){
        redis.clear();
    }

    public static String getRedisByKey(String key){
        if (!key.isEmpty()) {
            if (redis.get(key) != null)
                return redis.get(key);
        }
        return "";
    }
}

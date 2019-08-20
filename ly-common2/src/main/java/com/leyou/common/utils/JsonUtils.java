package com.leyou.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * Created by Bill.Tang on 2018-9-27.
 */

public class JsonUtils {
    // 定义jackson对象
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger= LoggerFactory.getLogger(JsonUtils.class);

    public  static  String toString(Object object){
        if(object==null){
            return  null;
        }
        if(object.getClass()==String.class){
            return (String) object;
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错！"+object,e);
            e.printStackTrace();
            return null;
        }
    }
    public static<T> T  toBean(String json,Class<T> tClass){
        try {
            return mapper.readValue(json,tClass);
        } catch (IOException e) {
            logger.error("json序列化出错！"+json,e);
           return null;
        }
    }

    public static<E> List<E> toList(String json,Class<E> eClass){
        try {
            return  mapper.readValue(json,mapper.getTypeFactory().constructCollectionType(List.class,eClass));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("json序列化出错！"+json,e);
            return null;
        }
    }
    
    public  static  <K,V> Map<K,V> toMap(String json,Class<K>  kClass, Class<V> vClass){
        try {
            return mapper.readValue(json,mapper.getTypeFactory().constructMapType(Map.class,kClass,vClass));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("json序列化出错！"+json,e);
            return null;
        }
    }
    public  static  <T> T  nativeRead(String json,TypeReference type){
        try {
            return mapper.readValue(json,type);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("json序列化出错！"+json,e);
            return null;
        }
    }
}


package com.clr.db.model;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/11/1 0001.
 */

public class Record {

    HashMap<String,Object> map = new HashMap<>();

    public String getString(String key){
        return (String)map.get(key);
    }
    public int getInt(String key){
        return (Integer)map.get(key);

    }
    public void setObject(String key,Object object){
        map.put(key,object);
    }

    public HashMap<String,Object>  getMap(){
        return map;
    }

}

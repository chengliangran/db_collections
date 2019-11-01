package com.clr.spider;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.jws.Oneway;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/30 0030.
 */

public class Spider {


    public static HashMap<String,String> defaultHeaders = new HashMap<>();

    public static HashMap<String ,String> addtionalHeaders = new HashMap<>();

    public static  HttpClient client= new HttpClient();

    static {
        defaultHeaders.put("Accept-Charset","utf-8");
        defaultHeaders.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0");
    }

    public static String sendGet(String url){
        GetMethod getMethod = new GetMethod(url);
        try {
            for (Map.Entry<String,String> header:defaultHeaders.entrySet()){
                String key = header.getKey();
                String value = header.getValue();
                getMethod.addRequestHeader(key,value);
            }

//            for (Map.Entry<String,String> param:params.entrySet()){
//                String key = param.getKey();
//                String value = param.getValue();
//             }
            client.executeMethod(getMethod);

            return getMethod.getResponseBodyAsString();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                getMethod.releaseConnection();
            }catch (Exception e){

            }
        }
        return null;
    }

    public static InputStream sendGet1(){

        return null;
    }

    public static String sendPost(String url,Map<String,String> params){
        PostMethod postMethod = new PostMethod(url);
        try {
            for (Map.Entry<String,String> header:defaultHeaders.entrySet()){
                String key = header.getKey();
                String value = header.getValue();
                postMethod.addRequestHeader(key,value);
            }

            for (Map.Entry<String,String> param:params.entrySet()){
                String key = param.getKey();
                String value = param.getValue();
                postMethod.addParameter(key,value);
            }
            client.executeMethod(postMethod);

            return postMethod.getResponseBodyAsString();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                postMethod.releaseConnection();
            }catch (Exception e){

            }
        }
        return null;

    }

    public static void addAdditionalHeaders(HashMap<String,String> map){
        addtionalHeaders.putAll(map);
    }

}

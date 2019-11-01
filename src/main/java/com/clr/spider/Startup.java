package com.clr.spider;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2019/10/30 0030.
 */

public class Startup {
    public static void main(String[] args) {
        //Spider spider = new Spider();
        try {
            String url = "https://movie.douban.com/subject/27109633";
            String url2 = "https://wwww.baidu.com";
            Spider spider = new Spider();
            System.out.println(Spider.sendGet(url));
        }catch (Exception e){

        }
    }
}

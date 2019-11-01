package com.clr.db;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2019/10/30 0030.
 */

public class Startup {

    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_collections?useSSL=false","root","123456");
//            Class c=  Startup.class;
//            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("create_table.sql");
//
//            byte[] buf = new byte[2048];
//            int i=inputStream.read(buf);
//            String create_book_sql = new String(buf,0,i);
//            System.out.println(create_book_sql);
//            Statement statement= connection.createStatement();
//            boolean result =  statement.execute(create_book_sql);
//            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(){

    }

 }

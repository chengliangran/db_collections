package com.clr.db;

import com.clr.db.model.Record;
import com.sun.org.apache.xml.internal.serializer.utils.BoolStack;

import java.awt.print.Book;
import java.sql.*;
import java.util.*;

/**
 * Created by Administrator on 2019/11/1 0001.
 */

public class DBManager {

    public static Connection connection = null;

    public static String[] bookKeys = {"id","name","author","summary","author_summary","catalog","pages","publisher","year","score"};

    static {
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_collections?useSSL=false","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertRecord(String table, Record record){
        if ("book".equals(table)){
            String sql =  "insert into ?(id,name,author,summary,author_summary,catalog,pages,publisher,year,score) values(?,?,?,?,?,?,?,?,?,?)";
            try {
              PreparedStatement statement =   connection.prepareStatement(sql);
              statement.setString(1,table);
                for (int i=2;i<bookKeys.length;i++){
                    statement.setString(i,record.getString(bookKeys[i-2]));
                }
                statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static List<Record> getRecord(String table, Record record,String orderBy){
        List<Record> books = new ArrayList<>();
        try {
            String condition = "";
            HashMap<String,Object> map =  record.getMap();
            for (Map.Entry<String,Object> entry:map.entrySet()){
                String key = entry.getKey();
                String value = (String) entry.getValue();
                condition += " and "+key + "='" +value+"'";
            }
            String sql  =  "select * from ? where 1=1 and "+condition+" "+orderBy;
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setString(1,table);
            ResultSet rs =  statement.executeQuery();
            if ("book".equals(table)){
                while (rs.next()){
                        Record book = new Record();
                        for (String key:bookKeys){
                            book.setObject(key,rs.getString(key));
                        }
                        books.add(book);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }

    public static void main(String[] args) {
        Record record = new Record();
        record.setObject("name","奥利弗游记");
        record.setObject("page","111");
        DBManager.getRecord("book",record,"");
    }
}

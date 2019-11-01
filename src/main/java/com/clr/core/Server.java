package com.clr.core;

import org.apache.commons.lang3.StringUtils;

import javax.xml.ws.Response;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Administrator on 2019/10/15 0015.
 */

public class Server {

    public static ServerSocket serverSocket=null;

    public String webRoot = this.getClass().getResource("/").getPath()+"../../src/main/webapp/";

    static {
        try {
            serverSocket= new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void accept() {
        try {
            int count=0;
            while (true){
                Socket socket  =  serverSocket.accept();
                System.out.println("接受到socket 数目是"+(++count));
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                byte[] buf = new byte[1024];
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                int lineNum = 0;
                while (true){
                    String line=   reader.readLine();
                    System.out.println(line);
                    if (StringUtils.isEmpty(line)){
                        System.out.println("end");
                        break;
                     }
                }
                String content = getContent("index.html");
                String response  = "HTTP/1.1 OK 200\r\n" +
                        "Content-Length:"+content.getBytes().length+"\r\n" +
                        getContent("headers.properties")+
                        "\r\n\r\n"+content;
                outputStream.write(response.getBytes());
                inputStream.close();
                outputStream.close();


            }
         }
        catch (Exception e){

        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(Server.class.getResource("/").toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        };

    }

    public String getContent(String fileName) {
        StringBuffer content = new StringBuffer();
         try {
            FileInputStream fis  = new FileInputStream(new File(webRoot+fileName));
            byte[] buf = new byte[1024];
            int i =-1;
            while ((i=fis.read(buf))>-1){
                content.append(new String(buf,0,i));
            }
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  content.toString();
    }
}

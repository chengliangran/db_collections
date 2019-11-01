import com.clr.core.Server;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.*;
import java.util.Timer;

/**
 * Created by Administrator on 2019/10/14 0014.
 */

public class Startup {

    public static String classPath = Startup.class.getResource("/").getPath();

    public static String javaPath = Startup.class.getResource("/").getPath()+"../../"+"src/main/java";


    public static JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    public static List<String> fileNames = new ArrayList<>();

    public static Thread checkClass = new Thread(new Runnable() {
        @Override
        public void run() {
            Timer timer  = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run(){

                }
            },10,20);
         }
    });



    static {
        checkClass.start();
     }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

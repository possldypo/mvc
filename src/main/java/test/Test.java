package test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by 黎 on 2017/11/19.
 */
public class Test {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("e:/test.txt");
            OutputStream outputStream = new FileOutputStream("e:/test2.txt");
            byte[] bytes = new byte[1024];
            int size = 0;
            while ((size = inputStream.read(bytes))>0){
                outputStream.write(bytes,0,size);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

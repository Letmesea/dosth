package com.rabbitmq.rabbitmq.util;

import java.io.*;

public class FileUtil {
    public static void writeFile(String path,String data){
        try {

            File file = new File(path);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            /*字符*/
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.flush();
            bw.close();

            /*字节*/
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(data.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();


            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFile(String url){
        try {
            File file = new File(url);
            /*字节流读入，一次一个*/
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int bytet;
            while ((bytet=bufferedInputStream.read())!=-1){
                System.out.print(bytet);
            }
            fileInputStream.close();
            bufferedInputStream.close();

            /*字符流，按行读取*/
            FileInputStream fileInputStream1 = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream1);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            while ((str=bufferedReader.readLine())!=null){
                System.out.println(str);
            }
            fileInputStream1.close();
            inputStreamReader.close();
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        String url = "D:\\prj\\coding\\dosth\\rabbitmq-p\\src\\main\\resources\\12.html";
        readFile(url);
    }
}

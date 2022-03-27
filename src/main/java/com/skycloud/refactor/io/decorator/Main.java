package com.skycloud.refactor.io.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

    private static final String movie = "E:\\迅雷下载\\1.txt";   // 2.54G
//    private static final String movie = "E:\\迅雷下载\\spark-1.6.3-bin-hadoop2.6.tgz";   // 2.54G
    public static void main(String[] args) {
        long startTime1 = System.currentTimeMillis();
        readByInput1(movie);
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("BufferedInputStream:"+(endTime1 - startTime1));
// 
//        long startTime2 = System.currentTimeMillis();
//        readByInput(movie);
//        long endTime2 = System.currentTimeMillis();
//        System.out.println("FileInputStream:"+(endTime2 - startTime2));
    }
    
    
    private static void readByInput1(String movie) {
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(movie);
            byte[] bytes = new byte[2];
            int x1 = inputStream.read(bytes);
            int x2 = inputStream.read(bytes);
            int x3 = inputStream.read(bytes);
            int x4 = inputStream.read(bytes);
            //            while (inputStream.read() != -1){
//            }
 
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try{
                    inputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
 
 
    private static void readByBuffer(String movie) {
        BufferedInputStream bufferedInputStream = null;
        try{
            bufferedInputStream = new BufferedInputStream(new FileInputStream(movie));
            byte[] bytes = new byte[2048];
            while (bufferedInputStream.read(bytes) != -1){
            }
 
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null){
                try{
                    bufferedInputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
 
    private static void readByInput(String movie) {
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(movie);
            byte[] bytes = new byte[2048];
            while (inputStream.read(bytes) != -1){
            }
 
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try{
                    inputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
 

}


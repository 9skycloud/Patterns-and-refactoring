package com.skycloud.refactor.io.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author 设计模式综合解析和重构实战 https://ke.qq.com/course/4030688
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.print("请输入一系列文字，可包括空格：");
		String text = bufferedReader.readLine();
		System.out.println("请输入文字：" + text);
	}

	public static void transReadNoBuf() throws IOException {
		/**
		 * 没有缓冲区，只能使用read()方法。
		 */
		// 读取字节流
		// InputStream in = System.in;//读取键盘的输入。
		InputStream in = new FileInputStream("D:\\demo.txt");// 读取文件的数据。
		// 将字节流向字符流的转换。要启用从字节到字符的有效转换，
		// 可以提前从底层流读取更多的字节.
		InputStreamReader isr = new InputStreamReader(in);// 读取
		// 综合到一句。
		// InputStreamReader isr = new InputStreamReader(
		// new FileInputStream("D:\\demo.txt"));
		char[] cha = new char[1024];
		int len = isr.read(cha);
		System.out.println(new String(cha, 0, len));
		isr.close();
	}

	public static void transReadByBuf() throws IOException {
		/**
		 * 使用缓冲区 可以使用缓冲区对象的 read() 和 readLine()方法。
		 */
		// 读取字节流
		// InputStream in = System.in;//读取键盘上的数据
		InputStream in = new FileInputStream("D:\\demo.txt");// 读取文件上的数据。
		// 将字节流向字符流的转换。
		InputStreamReader isr = new InputStreamReader(in);// 读取
		// 创建字符流缓冲区
		BufferedReader bufr = new BufferedReader(isr);// 缓冲
		// BufferedReader bufr = new BufferedReader(
		// new InputStreamReader(new FileInputStream("D:\\demo.txt")));可以综合到一句。
		/*
		 * int ch =0; ch = bufr.read(); System.out.println((char)ch);
		 */
		String line;
		while ((line = bufr.readLine()) != null) {
			System.out.println(line);
		}
		isr.close();
	}

}

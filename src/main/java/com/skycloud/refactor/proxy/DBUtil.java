package com.skycloud.refactor.proxy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;

public class DBUtil {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		// 1注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		String[] para = read();

		// 2建立连接
		String url = para[1];
		String usernName = para[2];
		String password = para[3];
		Connection conn = DriverManager.getConnection(url, usernName, password);

		// 3获取执行sQL语句的对象
		String sql = "select * from user where id = ? ";
//		Statement stmt = conn.createStatement();
//		stmt.execute(sql);
		PreparedStatement statement = conn.prepareStatement(sql);
		System.out.println("sql:"+sql);
		statement.setInt(1,2);
		System.out.println("参数："+2);
		// 4获取数据库返回的结果
		ResultSet resultSet = statement.executeQuery();
		// 5处理数据集
		try {
			int rows = 0;
			while (resultSet.next()) {
				// .getXXX方法中的参数 1，字段名 2.字段的下标
				int empno = resultSet.getInt("id");
				String ename = resultSet.getString("username");
				String job = resultSet.getString(3);
				String date = resultSet.getString(5);
				System.out.println("empno：" + empno + ", ename:" + ename
						+ ", job:" + job + ", date:" + date);
				rows++;
			}
			System.out.println("total results:"+rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6关闭连接
			resultSet.close();
			statement.close();
			conn.close();
		}
	}

	public static String[] read() throws IOException {
		FileReader fr = new FileReader(
				Resources.getResourceAsFile("jdbc.properties"));
		// 创建 写入 缓冲区
		BufferedReader bufferedReader = new BufferedReader(fr);
		String[] str = new String[4];
		for (int i = 0; i < 4; i++) {
			String line = bufferedReader.readLine();
			str[i] = line.substring(line.indexOf("=") + 1, line.length());
		}
		bufferedReader.close();
		fr.close();
		return str;
	}
}

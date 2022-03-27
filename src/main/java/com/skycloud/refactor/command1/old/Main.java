package com.skycloud.refactor.command1.old;

public class Main {

	public static void main(String[] args) {
		DataSource data = new FileDataSource();
		
		DataSource data2 = new EncryptionDecorator(data);
		DataSource data3 = new CompressDecorator(data2);
		
		System.out.println("把数据写入数据库：");
		data3.writeData("5615616119688refdaf888888888888888865555555555555511111111111111111111111119999999999999999999999999999999911111111111111111111333333333333333333");
		System.out.println("从数据库读取数据：");
		System.out.println(data3.readData());
	}

}

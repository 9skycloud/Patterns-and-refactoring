package com.skycloud.refactor.decorator.file;

public class Main {

	public static void main(String[] args) {
		FileDataSource file = new FileDataSource();
		
		CompressDecorator compress = new CompressDecorator(file);
//		
		EncryptionDecorator encry = new EncryptionDecorator(compress);
		
		System.out.println("--------写数据：--------");
		encry.writeData("aaaaaadddddddggggggggggghhhhhhhhhhhjjjjjjjjjjjjjjkkkkkkkkkk");
		System.out.println("--------读数据：--------");
		System.out.println(encry.readData());
	}

}

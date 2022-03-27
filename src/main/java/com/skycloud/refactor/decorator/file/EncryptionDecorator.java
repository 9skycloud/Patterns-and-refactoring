package com.skycloud.refactor.decorator.file;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;

public class EncryptionDecorator implements DataSourceService{
	
	private DataSourceService dataObject;
	
	public EncryptionDecorator(DataSourceService dataObject) {
		this.dataObject = dataObject;
	}

	@Override
	public void writeData(String data) {
		String result = new String(encryption(data));
		dataObject.writeData(result);
	}

	@Override
	public String readData() {
		String result = dataObject.readData();
		return new String(unEncryption(result)); 
	}
	
	private byte[] encryption(String data) {
		System.out.println("加密");
		return Base64.encode(data.getBytes());
	}

	private byte[] unEncryption(String result) {
		System.out.println("解密");
		return Base64.decode(result.getBytes());
	}

}

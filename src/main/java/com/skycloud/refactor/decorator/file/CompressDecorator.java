package com.skycloud.refactor.decorator.file;

import java.io.IOException;

import com.alibaba.dubbo.common.io.Bytes;

public class CompressDecorator implements DataSourceService{
	
	private DataSourceService dataObject;
	
	public CompressDecorator(DataSourceService dataObject) {
		this.dataObject = dataObject;
	}

	@Override
	public void writeData(String data) {
		byte[] result = compress(data);
		dataObject.writeData(Bytes.bytes2base64(result));
	}

	@Override
	public String readData() {
		String result = dataObject.readData();
		return new String(unCompress(result));
	}

	private byte[] compress(String data) {
		System.out.println("压缩");
		try {
			return Bytes.zip(data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private byte[] unCompress(String result) {
		System.out.println("解压缩");
		try {
			return Bytes.unzip(Bytes.base642bytes(result));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

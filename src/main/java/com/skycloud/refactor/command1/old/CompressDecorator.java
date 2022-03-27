package com.skycloud.refactor.command1.old;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.alibaba.dubbo.common.io.Bytes;


public class CompressDecorator implements DataSource {

	private DataSource dataObject;

	public CompressDecorator(DataSource dataObject) {
		this.dataObject = dataObject;
	}

	@Override
	public void writeData(String data) {
		// 压缩
		byte[] result = compressData(data);
		dataObject.writeData(Bytes.bytes2base64(result));
	}

	private byte[] compressData(String data) {
		byte[] b = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(bos);
			gzip.write(data.getBytes());
			gzip.finish();
			gzip.close();
			b = bos.toByteArray();
			bos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}

	@Override
	public String readData() {
		String result = dataObject.readData();
		return new String(uncompressData(Bytes.base642bytes(result)));
//		return null;
	}

	private byte[] uncompressData(byte[] data) {
		byte[] b = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
			GZIPInputStream gzip = new GZIPInputStream(bis);
			byte[] buf = new byte[1024];
			int num = -1;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((num = gzip.read(buf, 0, buf.length)) != -1) {
				baos.write(buf, 0, num);
			}
			b = baos.toByteArray();
			baos.flush();
			baos.close();
			gzip.close();
			bis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}
	
	public static void main(String[] args) throws IOException {
		CompressDecorator d = new CompressDecorator(null);
		String in = "5615616119688refdaf888888888888888865555555555555511111111111111111111111119999999999999999999999999999999911111111111111111111333333333333333333";
//		byte[] x=d.compressData("");
		byte[] x=Bytes.zip(in.getBytes());
		byte[] x1=Bytes.unzip(Bytes.base642bytes(Bytes.bytes2base64(x)));
//		byte[] x1=d.uncompressData(xxx.getBytes());
		System.out.println(new String(x));
		System.out.println(new String(x1));
		
//		String  str = "5615616119688refdaf888888888888888865555555555555511111111111111111111111119999999999999999999999999999999911111111111111111111333333333333333333";
//	    System.out.println(str); 
//		byte[] sb = str.getBytes();
//		System.out.println(sb);
//	     System.out.println(new String(sb));
//	     System.out.println(new String(sb).getBytes());
	}

}

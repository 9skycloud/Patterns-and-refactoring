package com.skycloud.refactor.command1.old;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;

public class EncryptionDecorator implements DataSource {

	private DataSource dataObject;
	
	public EncryptionDecorator(DataSource dataObject) {
		this.dataObject = dataObject;
	}

	@Override
	public void writeData(String data) {
		String result = encryption(data);
		dataObject.writeData(result);
	}

	private String encryption(String text) {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            try (DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(out)) {
                deflaterOutputStream.write(text.getBytes("utf-8"));
            }
            return new String(Base64.encode(out.toByteArray()));
        } catch (IOException e) {
            System.out.println("压缩文本失败:{}");
        }
		System.out.println("加密");
        return null;
	}

	@Override
	public String readData() {
		String result = dataObject.readData();
		return unEncryption(result);
	}

	private String unEncryption(String text) {
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            try (OutputStream outputStream = new InflaterOutputStream(os)) {
                outputStream.write(Base64.decode(text.getBytes()));
            }
            return new String(os.toByteArray(),"utf-8");
        } catch (IOException e) {
        	System.out.println("解压文本失败:{}");
        }
        return null;
	}

	
}

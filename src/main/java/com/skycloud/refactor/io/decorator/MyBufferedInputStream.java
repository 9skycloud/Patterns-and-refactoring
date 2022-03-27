package com.skycloud.refactor.io.decorator;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author 设计模式综合解析和重构实战 https://ke.qq.com/course/4030688
 *
 */
public class MyBufferedInputStream {

	private int markpos;
	private int pos;
	private int count;
	private int marklimit;
	private InputStream in;
	private static final AtomicReferenceFieldUpdater<MyBufferedInputStream, byte[]> bufUpdater = AtomicReferenceFieldUpdater
			.newUpdater(MyBufferedInputStream.class, byte[].class, "buf");

	// 情况1. 读取完buffer中的数据，并且buffer没有被标记
	//(pos >= count)
	private void fill1() throws IOException {
		byte[] buffer = getBufIfOpen();
		if (markpos < 0)
			pos = 0;

		count = pos;
		int n = (getInIfOpen()).read(buffer, pos, buffer.length - pos);
		if (n > 0)
			count = n + pos;
	}

	// 情况2：读取完buffer中的数据，buffer的标记位置>0，并且buffer中没有多余的空间
	private void fill2() throws IOException {
		byte[] buffer = getBufIfOpen();
		if (markpos >= 0 && pos >= buffer.length) {
			if (markpos > 0) {
				int sz = pos - markpos;
				System.arraycopy(buffer, markpos, buffer, 0, sz);
				pos = sz;
				markpos = 0;
			}
		}

		count = pos;
		int n = getInIfOpen().read(buffer, pos, buffer.length - pos);
		if (n > 0)
			count = n + pos;
	}

	// 情况3：读取完buffer中的数据，buffer被标记位置=0，buffer中没有多余的空间，并且buffer.length>=marklimit
	private void fill3() throws IOException {
		byte[] buffer = getBufIfOpen();
		if (markpos >= 0 && pos >= buffer.length) {
			if ((markpos <= 0) && (buffer.length >= marklimit)) {
				markpos = -1; /* buffer got too big, invalidate mark */
				pos = 0; /* drop buffer contents */
			}
		}

		count = pos;
		int n = getInIfOpen().read(buffer, pos, buffer.length - pos);
		if (n > 0)
			count = n + pos;
	}

	// 情况4：读取完buffer中的数据，buffer被标记位置=0，buffer中没有多余的空间，并且buffer.length<marklimit
	private void fill4() throws IOException {
		byte[] buffer = getBufIfOpen();
		if (markpos >= 0 && pos >= buffer.length) {
			if ((markpos <= 0) && (buffer.length < marklimit)) {
				int nsz = pos * 2;
				if (nsz > marklimit)
					nsz = marklimit;
				byte nbuf[] = new byte[nsz];
				System.arraycopy(buffer, 0, nbuf, 0, pos);
				if (!bufUpdater.compareAndSet(this, buffer, nbuf)) {
					throw new IOException("Stream closed");
				}
				buffer = nbuf;
			}
		}

		count = pos;
		int n = getInIfOpen().read(buffer, pos, buffer.length - pos);
		if (n > 0)
			count = n + pos;
	}

	private void fill() throws IOException {
		byte[] buffer = getBufIfOpen();

		count = pos;
		int n = getInIfOpen().read(buffer, pos, buffer.length - pos);
		if (n > 0)
			count = n + pos;
	}

	private InputStream getInIfOpen() throws IOException {
		InputStream input = in;
        if (input == null)
            throw new IOException("Stream closed");
        return input;
	}

	private byte[] getBufIfOpen() {
		// TODO Auto-generated method stub
		return null;
	}

}

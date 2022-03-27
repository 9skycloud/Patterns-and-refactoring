package com.skycloud.refactor.command1.old;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileDataSource implements DataSource {

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.command1.old.DataSource#writeData()
	 */
	@Override
	public void writeData(String data){
		try {
            FileOutputStream fos=new FileOutputStream("E://database/file.txt");
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            bos.write(data.getBytes(),0,data.getBytes().length);
            bos.flush();
            bos.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
		System.out.println("写入数据");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.command1.old.DataSource#readData()
	 */
	@Override
	public String readData(){
		File file = new File("E://database/file.txt");
	    BufferedReader reader = null;
	    StringBuffer sbf = new StringBuffer();
	    try {
	        reader = new BufferedReader(new FileReader(file));
	        String tempStr;
	        while ((tempStr = reader.readLine()) != null) {
	            sbf.append(tempStr);
	        }
	        reader.close();
	        return sbf.toString();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
	    System.out.println("读取数据");
	    return sbf.toString();
	}
}

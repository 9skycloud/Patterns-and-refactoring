package com.skycloud.refactor.decorator.file;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class FileDataSource implements DataSourceService {
	
	private String fileName = "E://database/111.txt";
	

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.decorator.file.DataSourceService#writeData(java.lang.String)
	 */
	@Override
	public void writeData(String data){
		System.out.println("写入数据");
		
		try {
			FileOutputStream out = new FileOutputStream(fileName);
			BufferedOutputStream br = new BufferedOutputStream(out);
			br.write(data.getBytes());
			br.flush();
			br.close();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.decorator.file.DataSourceService#readData()
	 */
	@Override
	public String readData(){
		System.out.println("读取数据");
		StringBuffer sb = new StringBuffer();
		try {
			FileReader reader = new FileReader(fileName);
			BufferedReader bf = new BufferedReader(reader);
			String str = null;
			while((str = bf.readLine())!=null){
				sb.append(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
}

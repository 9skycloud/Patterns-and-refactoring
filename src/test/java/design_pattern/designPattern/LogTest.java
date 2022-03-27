package design_pattern.designPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import junit.framework.TestSuite;

import org.apache.ibatis.io.Resources;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mysql.cj.jdbc.Driver;




public class LogTest {
	
	/**
	 * import org.slf4j.Logger;
	   import org.slf4j.LoggerFactory;
	 */
	public static final Logger log = LoggerFactory.getLogger(LogTest.class);
	
	/**
	 * import org.apache.commons.logging.Log;
	   import org.apache.commons.logging.LogFactory;
	 */
//	private static final Log log = LogFactory.getLog(LogTest.class);

	public static void main(String[] args) {
//		testLog();
		
		Thread t = new Thread(new Runnable(){
			LogTest receiver = new LogTest();
			@Override
			public void run() {
				receiver.testLog();
			}
			
		});
		
		t.start();
	}
	
	public static void testLog(){
//		ArrayList<String> list = new ArrayList<>();
//		list.add("zhangsan");
//		list.add("lisi");
//		list.add("wangwu");
//		ArrayList other = (ArrayList) list.clone();
		HashMap<String,String> map = new HashMap();
		map.put("123", "zhangsan");
		map.put("124", "lisi");
		map.put("125", "wangwu");
		HashMap other = (HashMap) map.clone();
		System.out.println(other.toString());
		/*try{
			log.info("第一次打印！");
			log.debug("debug");
			log.error("error");
			log.warn("警告");
			log.trace("trace");
		}catch(Exception e){
			log.error("error:"+e.getMessage());
		}*/
	}
	
	public static void testInteger(){
		Integer val127 = Integer.valueOf(127);
		Integer otherVal127 = Integer.valueOf(127);
		
		Integer new127 = new Integer(127);
		Integer otherNew127 = new Integer(127);
		System.out.println(val127 == otherVal127);
		System.out.println(new127 == otherNew127);
	}
	
	public static Test suite() {
		TestSuite suite1 = new TestSuite("我的测试TestSuit1");
		TestSuite suite2 = new TestSuite("我的测试TestSuit2");
		suite1.addTest(suite2);
		return (Test) suite1;
	}
	
	public static void testString(){
		AbstractFactoryBean bean = null;
		Timer timer =new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				
			}
			
		}, 100);
		HashMap map = null;
		AbstractList list = null;
		String s0="kvill";

		String s1="kvill";

		String s2="kv" + "ill";

		System.out.println( s0==s1 );

		System.out.println( s0==s2 );
	}
	
	public static void testDriver(){
		try {
			java.sql.Driver driver = new Driver();
			Properties prop = new Properties();
			FileReader fr;
			try {
				fr = new FileReader(
						Resources.getResourceAsFile("jdbc.properties"));
				prop.load(new BufferedReader(fr));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Connection conn = driver.connect(prop.getProperty("url"), prop);
		} catch (SQLException e) {
			e.printStackTrace();
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

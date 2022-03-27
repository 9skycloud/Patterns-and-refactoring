package com.skycloud.refactor.proxy.mybatis.plugin;

import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.jdbc.PreparedStatementLogger;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
@Intercepts({
	@Signature(args = {Statement.class, ResultHandler.class}, method = "query", type = StatementHandler.class)
})
public class MyIntercepter implements Interceptor{
	
	private Log log = LogFactory.getLog(MyIntercepter.class);

	private long threshold;
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = invocation.proceed();
		long end = System.currentTimeMillis();
		long runtime = end - start;
		if(runtime >= threshold){
			MetaObject metaObj = SystemMetaObject.forObject(invocation.getArgs()[0]);
			PreparedStatementLogger p = (PreparedStatementLogger) metaObj.getValue("h");
			Statement st = p.getPreparedStatement();
			log.info("SQL语句："+st.toString()+"运行时间："+runtime+"超出了阈值范围");
		}
		return obj;
	}
	
	@Override
	public void setProperties(Properties properties) {
		threshold = Long.valueOf(properties.getProperty("threshold"));
	}

}


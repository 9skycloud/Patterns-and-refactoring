package com.skycloud.refactor.mediator.dataExchange;

import java.util.LinkedList;
import java.util.List;

public class RedisDaoImpl extends DaoService {
    private List<String> dataset = new LinkedList<String>();
    
    private MysqlDaoImpl mysqlDatabase;
    

	@Override
    public void addData(String data) {
        System.out.println("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data); // 同步到mysql
        mysqlDatabase.addData(data);
    }

    public void cache() {
        System.out.println("- Redis 缓存的数据：" + this.dataset.toString());
    }

	public MysqlDaoImpl getMysqlDatabase() {
		return mysqlDatabase;
	}

	public void setMysqlDatabase(MysqlDaoImpl mysqlDatabase) {
		this.mysqlDatabase = mysqlDatabase;
	}
    
    
}

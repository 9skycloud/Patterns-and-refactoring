package com.skycloud.refactor.mediator.dataExchange;

import java.util.ArrayList;
import java.util.List;

public class MysqlDaoImpl extends DaoService {
    private List<String> dataset = new ArrayList<String>();
    private RedisDaoImpl redisDatabase;
    private EsDaoImpl esDatabase;

    @Override
    public void addData(String data) {
        System.out.println("Mysql 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data);
        this.redisDatabase.addData(data);   // 同步到Redis
        this.esDatabase.addData(data);  // 同步到Es
    }

    public void select() {
        System.out.println("- Mysql 查询，数据：" + this.dataset.toString());
    }

	public List<String> getDataset() {
		return dataset;
	}

	public void setDataset(List<String> dataset) {
		this.dataset = dataset;
	}

	public RedisDaoImpl getRedisDatabase() {
		return redisDatabase;
	}

	public void setRedisDatabase(RedisDaoImpl redisDatabase) {
		this.redisDatabase = redisDatabase;
	}

	public EsDaoImpl getEsDatabase() {
		return esDatabase;
	}

	public void setEsDatabase(EsDaoImpl esDatabase) {
		this.esDatabase = esDatabase;
	}
    
    
}

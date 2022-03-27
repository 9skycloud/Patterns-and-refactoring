package com.skycloud.refactor.mediator.dataExchange01;

import java.util.ArrayList;
import java.util.List;

public class MysqlDaoImpl extends DaoService {
    public MysqlDaoImpl(SyncDataService syncDataService) {
		super(syncDataService);
	}

	private List<String> dataset = new ArrayList<String>();

    @Override
    public void addData(String data) {
        System.out.println("Mysql 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data);
        syncDataService.sync(DatabaseType.mysql,data);
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

    
    
}

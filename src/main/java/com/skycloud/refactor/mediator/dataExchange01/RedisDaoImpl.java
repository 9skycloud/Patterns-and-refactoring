package com.skycloud.refactor.mediator.dataExchange01;

import java.util.LinkedList;
import java.util.List;

public class RedisDaoImpl extends DaoService {
    public RedisDaoImpl(SyncDataService syncDataService) {
		super(syncDataService);
	}

	private List<String> dataset = new LinkedList<String>();
    
	@Override
    public void addData(String data) {
        System.out.println("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data); // 同步到mysql
        syncDataService.sync(DatabaseType.redis,data);
    }

    public void cache() {
        System.out.println("- Redis 缓存的数据：" + this.dataset.toString());
    }

    
}

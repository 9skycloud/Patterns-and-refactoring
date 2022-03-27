package com.skycloud.refactor.mediator.dataExchange01;

public abstract class DaoService {
	
	protected SyncDataService syncDataService;
	
    public DaoService(SyncDataService syncDataService) {
		this.syncDataService = syncDataService;
	}

	public abstract void add(String data);

    public abstract void addData(String data);
}

package com.skycloud.refactor.mediator.dataExchange01;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EsDaoImpl extends DaoService {
    public EsDaoImpl(SyncDataService syncDataService) {
		super(syncDataService);
	}

	private List<String> dataset = new CopyOnWriteArrayList<String>();
    @Override
    public void addData(String data) {
        System.out.println("ES 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data);
    }

    public void count() {
        int count = this.dataset.size();
        System.out.println("- Elasticsearch 统计，目前有 " + count + " 条数据，数据：" + this.dataset.toString());
    }

	public List<String> getDataset() {
		return dataset;
	}

	public void setDataset(List<String> dataset) {
		this.dataset = dataset;
	}

}

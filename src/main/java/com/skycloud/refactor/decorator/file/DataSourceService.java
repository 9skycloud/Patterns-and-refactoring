package com.skycloud.refactor.decorator.file;

public interface DataSourceService {

	public abstract void writeData(String data);

	public abstract String readData();

}
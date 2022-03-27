package com.skycloud.refactor.mediator.dataExchange01;

public interface SyncDataService {

	void sync(DatabaseType type,String data);
	
	void setMysqlDatabase(MysqlDaoImpl mysqlDatabase);
	
	void setRedisDatabase(RedisDaoImpl redisDatabase);
	
	void setEsDatabase(EsDaoImpl esDatabase);
}

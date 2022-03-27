package com.skycloud.refactor.mediator.dataExchange01;

public class SyncDataServiceImpl implements SyncDataService {
	
	private MysqlDaoImpl mysqlDatabase;
	
	private RedisDaoImpl redisDatabase;
    private EsDaoImpl esDatabase;

	@Override
	public void sync(DatabaseType type,String data) {
		
		if(type.equals(DatabaseType.redis))
			//redis
			mysqlDatabase.addData(data);
		else{
			//mysql
			this.redisDatabase.addData(data);   // 同步到Redis
			this.esDatabase.addData(data);  // 同步到Es
		}
	}
	
	public MysqlDaoImpl getMysqlDatabase() {
		return mysqlDatabase;
	}

	public void setMysqlDatabase(MysqlDaoImpl mysqlDatabase) {
		this.mysqlDatabase = mysqlDatabase;
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

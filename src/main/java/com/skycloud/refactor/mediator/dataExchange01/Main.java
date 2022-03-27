package com.skycloud.refactor.mediator.dataExchange01;

public class Main {
    public static void main(String[] args) {
    	SyncDataService service = new SyncDataServiceImpl();
        MysqlDaoImpl mysqlDatabase = new MysqlDaoImpl(service);
        RedisDaoImpl redisDatabase = new RedisDaoImpl(service);
        EsDaoImpl esDatabase = new EsDaoImpl(service);

        service.setRedisDatabase(redisDatabase);
        service.setEsDatabase(esDatabase);
        service.setMysqlDatabase(mysqlDatabase);

        System.out.println("---------添加数据到mysql ，将同步到Redis和ES中-----------");
        mysqlDatabase.add("data1");

        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("---------添加数据到Redis，将同步到mysql数据库-----------");
        redisDatabase.add("data2");

        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

    }
}

package com.skycloud.refactor.mediator.dataExchange;

public class Main {
    public static void main(String[] args) {
        MysqlDaoImpl mysqlDatabase = new MysqlDaoImpl();
        RedisDaoImpl redisDatabase = new RedisDaoImpl();
        EsDaoImpl esDatabase = new EsDaoImpl();

        mysqlDatabase.setRedisDatabase(redisDatabase);
        mysqlDatabase.setEsDatabase(esDatabase);
        redisDatabase.setMysqlDatabase(mysqlDatabase);

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

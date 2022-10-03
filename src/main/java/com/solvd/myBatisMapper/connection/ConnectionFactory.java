package com.solvd.myBatisMapper.connection;


import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class ConnectionFactory {
    private final String USERNAME="root";
    private final String PASSWORD="root";
    private final String DATABASE="bank";
    String urlDB = "jdbc:mysql://localhost:3306/"+DATABASE;
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    DataSource dataSource = new PooledDataSource(DRIVER, urlDB, USERNAME, PASSWORD);

    public SqlSession buildConnection(Class myClass){
        Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(myClass);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory= builder.build(configuration);
        return factory.openSession();
    }


}

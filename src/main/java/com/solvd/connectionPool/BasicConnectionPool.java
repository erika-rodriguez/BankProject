package com.solvd.connectionPool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnectionPool implements IConnectionPool{
    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPoolList;
    private List<Connection> usedConnectionsList = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 10;

    // constructor
    public BasicConnectionPool(String url, String user, String password, List<Connection> pool) {
    }

    public static BasicConnectionPool create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new BasicConnectionPool (url, user, password, pool);
    }


    @Override
    public Connection getConnection() {
        Connection connection = connectionPoolList.remove(connectionPoolList.size() - 1);
        usedConnectionsList.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPoolList.add(connection);
        return usedConnectionsList.remove(connection);
    }
    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPoolList.size() + usedConnectionsList.size();
    }

    //getters and setters
    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}

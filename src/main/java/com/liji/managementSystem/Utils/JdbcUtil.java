package com.liji.managementSystem.Utils;

import org.h2.jdbc.JdbcConnection;
import org.h2.jdbcx.JdbcConnectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JdbcUtil {

    private static JdbcConnectionPool cp=null;

    static {

        try {
            InputStream in= JdbcUtil.class.getResourceAsStream("/h2config.properties");
            Properties properties=new Properties();
            properties.load(in);
            cp=JdbcConnectionPool.create(properties.getProperty("JDBC_URL"),properties.getProperty("USER"),properties.getProperty("PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        return cp.getConnection();
    }

    public static JdbcConnectionPool getCp(){
        return cp;
    }
}

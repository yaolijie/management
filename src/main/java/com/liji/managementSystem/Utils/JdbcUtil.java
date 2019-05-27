package com.liji.managementSystem.Utils;

import org.h2.jdbc.JdbcConnection;
import org.h2.jdbcx.JdbcConnectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

    private static Connection connection=null;

    static {

        try {
            InputStream in= JdbcUtil.class.getResourceAsStream("/h2config.properties");
            //加载数据库驱动
            Class.forName("org.h2.Driver");
            String url="jdbc:h2:~/test";
            String name="sa";
            String pwd="";
            connection=DriverManager.getConnection(url,name,pwd);
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}

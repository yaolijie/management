package com.liji.managementSystem.Listener;

import org.h2.tools.Server;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class D2DBServertStarListener implements ServletContextListener {

    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try{
            System.out.println("正在启动h2 数据库。。。。。。。");
            server=Server.createTcpServer().start();
            System.out.println("h2 数据库启动成功。。。。。。。。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (this.server!=null){
            this.server.stop();
            this.server=null;
        }
    }
}

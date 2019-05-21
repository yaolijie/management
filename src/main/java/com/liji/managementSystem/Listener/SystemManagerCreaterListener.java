package com.liji.managementSystem.Listener;

import com.liji.managementSystem.model.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SystemManagerCreaterListener implements ServletContextListener {


   // private User user=new User();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        //查询系统默认账号是否存在，如果不存在，创建一个默认账号

        User user=new User();
        if (user==null){
            user.setName("admin");
            user.setPassworld("1");

            //设置为管理员用户


            //保存用户到表
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

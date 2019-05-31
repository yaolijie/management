package com.liji.managementSystem.Hendle;

import com.liji.managementSystem.Utils.JdbcUtil;
import com.liji.managementSystem.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryHeadle {

    public static List<User> queryUser(){
        //RecordSet recordSet=null;
        ResultSet resultSet=null;
        Connection connection=null;
        String sql="select * from user t where 1=1 ";
        List<User> list=new ArrayList<User>();
        PreparedStatement preparedStatement=null;
        try{
            connection= JdbcUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            int i=0;
            while (resultSet.next()){
                User user=new User();
                user=(User)resultSet.getObject(i);
                list.add(user);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

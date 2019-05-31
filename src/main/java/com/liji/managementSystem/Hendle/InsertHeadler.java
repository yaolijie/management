package com.liji.managementSystem.Hendle;

import com.liji.managementSystem.Utils.JdbcUtil;
import com.liji.managementSystem.model.Organ;
import com.liji.managementSystem.model.User;
import com.liji.managementSystem.model.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertHeadler {

    public static Boolean insertOrgan(User user, UserAccount account) {

        boolean result=false;
        String insetUser="insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection=null;
        Statement statement=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=JdbcUtil.getConnection();
            statement=connection.createStatement();
            String inserAccount="insert into user_account values('" +
                    account.getUuid() +
                    "','" +
                    user.getUser_id()+
                    "','" +
                    account.getUserName() +
                    "','" +
                    account.getPassWorld() +
                    "','" +
                    account.getCreateTime().toString() +
                    "','" +
                    "'" +
                    ",'" +
                    "'" +
                    ",'" +
                    "')";
            statement.execute(inserAccount);
            preparedStatement=connection.prepareStatement(insetUser);
            preparedStatement.setString(1,user.getUuid());
            preparedStatement.setString(2,user.getUser_id());
            preparedStatement.setString(3,user.getNameFull());
            preparedStatement.setString(4,user.getName());
            preparedStatement.setString(5,user.getUseriId());
            preparedStatement.setString(6,user.getDeptId());
            preparedStatement.setString(7,user.getDeptName());
            preparedStatement.setString(8,user.getAge());
            preparedStatement.setString(9,user.getSex());
            preparedStatement.setString(10,user.getSchool());
            preparedStatement.setString(11,user.getEdu());
            preparedStatement.setString(12,user.getCreateTime());
            preparedStatement.setString(13,user.getCreateUuid());
            preparedStatement.setString(14,user.getCreateName());
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (statement!=null)
                    statement.close();
                    preparedStatement.close();
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public boolean insertOrgan(Organ organ){
        boolean result=false;
        String sql="insert into organ values(?,?,?,?,?,?,?,?,?)";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=JdbcUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,organ.getUuid());
            preparedStatement.setString(2,organ.getOrganId());
            preparedStatement.setString(3,organ.getOrganName());
            preparedStatement.setString(4,organ.getCode());
            preparedStatement.setString(5,organ.getsOrgganCode());
            preparedStatement.setString(6,organ.getCreateTime());
            preparedStatement.setString(7,organ.getCreateUuid());
            preparedStatement.setString(8,organ.getCreateName());
            preparedStatement.setString(9,organ.getType());
            result=preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (preparedStatement!=null){
                    preparedStatement.close();
                    if (connection!=null)
                        connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}

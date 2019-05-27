package com.liji.managementSystem.Hendle;

import com.liji.managementSystem.Utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateHeadle {

    static Connection connection= null;
    static {
        connection=JdbcUtil.getConnection();
    }

    public static void createUser() throws SQLException {

        Statement statement=null;
        try{
            String createUser="create table user(\n" +
                    "   uuid varchar(64) primary key not null,\n" +
                    "   user_id varchar(64) not null,\n" +
                    " user_full varchar(64), " +
                    "user_name varchar(32) null,\n" +
                    "   userID varchar(18) null,\n" +
                    "   dept_id varchar(64),\n" +
                    "   dept_name varchar(64),\n" +
                    "   age varchar(2),\n" +
                    "   sex varchar(2),\n" +
                    "   school varchar(20),\n" +
                    "   edu varchar(34),\n" +
                    "  create_time varchar(64),\n" +
                    "  create_uuid varchar(64),\n" +
                    "  create_name varchar(32)\n" +
                    "  )";
            String sqljction="create table organ(\n" +
                    "   uuid varchar(64) primary key not null,\n" +
                    "   organ_id varchar(64) not null,\n" +
                    "   organ_name varchar(32) null,\n" +
                    "   code varchar(32) ,\n" +
                    "  s_organ_id varchar(64),\n" +
                    "  create_time varchar(64),\n" +
                    "  create_uuid varchar(64),\n" +
                    "  create_name varchar(32),\n" +
                    "  type varchar(4)\n" +
                    "  )";
            String sqlorgan="create table user_account(\n" +
                    "   uuid varchar(64) primary key not null,\n" +
                    "   user_id varchar(64) not null,\n" +
                    "   user_name varchar(32) null,\n" +
                    "   passworld varchar(12) not null,\n" +
                    "  create_time varchar(64),\n" +
                    "  create_uuid varchar(64),\n" +
                    "  create_name varchar(32),\n" +
                    "  type varchar(4)\n" +
                    "  )";
            statement=connection.createStatement();
            statement.execute(createUser);
            statement.execute(sqljction);
            statement.execute(sqlorgan);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (statement!=null){
                statement.close();
            }
        }

    }
}

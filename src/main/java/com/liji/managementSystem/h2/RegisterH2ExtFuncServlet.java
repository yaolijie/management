package com.liji.managementSystem.h2;

import com.liji.managementSystem.Utils.JdbcUtil;
import com.liji.managementSystem.h2.H2DBFunctionExt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterH2ExtFuncServlet extends HttpServlet {

    public static final long seriaVersuinUID=4379248669825545593L;

    public void init() throws ServletException{

        //com.liji.managementSystem.h2.H2DBFunctionExt.uuid
        String sql1="CREATE ALIAS IF NOT EXISTS uuid FOR \"com.liji.managementSystem.h2.H2DBFunctionExt.uuid\"";

        String sql2="CREATE ALIAS IF NOT EXISTS uuid FOR \"com.liji.managementSystem.h2.H2DBFunctionExt.now\"";

        String sql3="CREATE ALIAS IF NOT EXISTS uuid FOR \"com.liji.managementSystem.h2.H2DBFunctionExt.getIp\"";

        String sql4="CREATE ALIAS IF NOT EXISTS uuid FOR \"com.liji.managementSystem.h2.H2DBFunctionExt.date_format\"";


        Connection connection=null;
        Statement statement=null;

        try{
            connection=JdbcUtil.getConnection();
            statement=connection.createStatement();
            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.addBatch(sql3);
            statement.addBatch(sql4);
            statement.executeBatch();
            System.out.println("H2数据库扩展函数注册成功！");
            statement.clearBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

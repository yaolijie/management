package com.liji.managementSystem.Servlet;

import com.liji.managementSystem.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.*;

public class LandServlet extends HttpServlet {


    PreparedStatement statement=null;
    Connection connection=null;

    public void init(){


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        doPOST(request,response);
    }

    public void doPOST(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        String name=request.getParameter("user");
        String pwd=request.getParameter("pwd");
        User user=new User();
        try {
            statement=connection.prepareStatement("select t.name,t.passworld from tab_user t where t.name= ?");
            statement.setString(1,name);
            ResultSet set=statement.executeQuery();
            if (set.next()){

                user.setName(set.getString("name"));
                user.setPassworld(set.getString("passworld"));
                if (pwd.equals(set.getString("passworld"))){
                    //登陆成功
                    request.getSession().setAttribute("USER_IN_SESSION",user);
                    response.sendRedirect("");
                    return;
                }else{
                    request.setAttribute("error","用户名或密码错误！！！");
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                    return;
                }
            }

            set.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

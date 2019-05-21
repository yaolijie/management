package com.liji.managementSystem.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LendOutServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        //.删除当前登录的用户信息
        request.getSession().removeAttribute("USER_IN_SESSION");
        response.sendRedirect("/index.jsp");

        //销毁整个session（推荐）
        //request.getSession().invalidate();
    }
}

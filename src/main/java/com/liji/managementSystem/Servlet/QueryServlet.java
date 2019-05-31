package com.liji.managementSystem.Servlet;

import com.liji.managementSystem.Hendle.QueryHeadle;
import com.liji.managementSystem.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

        String method=request.getParameter("t");
        if ("queryUser".equalsIgnoreCase(method)){
            queryUser(request,response);
        }
    }

    public void queryUser(HttpServletRequest request, HttpServletResponse response){
        List<User> list=QueryHeadle.queryUser();
        if (list.size()>0){
            request.setAttribute("list",list);
        }else{
            request.setAttribute("list",null);
        }
        try{
            request.getRequestDispatcher("/view/queryUser.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

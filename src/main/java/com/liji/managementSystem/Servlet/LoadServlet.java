package com.liji.managementSystem.Servlet;

import com.liji.managementSystem.Hendle.CreateHeadle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoadServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

        String method=request.getMethod();
        if ("create".equals(method)){
            createTable();
        }


    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{


        String method=request.getParameter("method");
        if ("create".equals(method)){
            createTable();
        }
    }

    public void createTable(){
        try{
            CreateHeadle.createUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

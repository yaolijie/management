package com.liji.managementSystem.Servlet;

import com.liji.managementSystem.Hendle.InsertHeadler;
import com.liji.managementSystem.model.User;
import com.liji.managementSystem.model.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class InsertServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        User user=new User();
        UserAccount account=new UserAccount();
        user.setName(request.getParameter("name"));
        user.setUuid(UUID.randomUUID().toString());
        user.setUser_id(UUID.randomUUID().toString());
        user.setSex(request.getParameter("sex"));
        user.setAge(request.getParameter("age"));
        user.setUseriId(request.getParameter("userId"));
        user.setEdu(request.getParameter("edu"));
        user.setSchool(request.getParameter("sch"));
        user.setDeptName(request.getParameter("dept"));
        user.setNameFull(request.getParameter("nameFull"));

        account.setUuid(UUID.randomUUID().toString());
        account.setUuid(user.getUser_id());
        account.setUserName(user.getName());
        account.setPassWorld(request.getParameter("pwd"));
        account.setCreateTime(new Date());

        InsertHeadler.insertOrgan(user,account);

    }
}

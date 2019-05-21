package com.liji.managementSystem.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class LengFilter implements javax.servlet.Filter {

    private List<String> needCheckURIs;

    public void init(FilterConfig filterConfig) throws ServletException{

        String needCheckUrl=filterConfig.getInitParameter("needCheckUrl");
        String[] split=needCheckUrl.split(",");
        needCheckURIs= Arrays.asList(split);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse res=(HttpServletResponse)servletResponse;
        String requesturl=req.getRequestURI();
        if (!needCheckURIs.contains(requesturl)){
            filterChain.doFilter(req,res);
            return;
        }

        Object user=req.getSession().getAttribute("USER_IN_SESSION");
        if (user==null){
            res.sendRedirect("/index.jsp");
            return;
        }

        filterChain.doFilter(req,res);
    }

    @Override
    public void destroy() {

    }

}

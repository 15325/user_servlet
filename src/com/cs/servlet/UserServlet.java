package com.cs.servlet;

import com.cs.entity.User;
import com.cs.service.impl.UserServiceImpl;
import com.cs.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
@SuppressWarnings("all")

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm = request.getParameter("comm");
        if (comm.equals("list")) {
            String pageNO = request.getParameter("indexno");
            if (pageNO == null || pageNO == "") {
                pageNO = "1";
            }
            int pno = Integer.parseInt(pageNO);
            UserServiceImpl usi = new UserServiceImpl();
            PageSupport
                    ps = new PageSupport();
            ps.setCurrentPageNo(pno);
            ps.setPageSize(3);
            try {
                ps.setTotalCount(usi.findByCountUser());
                List<User> list = usi.findByPageUserInfo(ps.getCurrentPageNo(), ps.getPageSize());
                if (list.size() > 0 && list != null) {
                    request.getSession().setAttribute("list", list);
                    request.getSession().setAttribute("ps", ps);
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (comm.equals("query")) {
            UserServiceImpl usi = new UserServiceImpl();
            String id = request.getParameter("id");
            int ids = Integer.parseInt(id);
            User us = null;
            try {
                us = usi.findByidUserInfo(ids);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (us != null) {
                request.setAttribute("us", us);
                request.getRequestDispatcher("query.jsp").forward(request, response);
            } else {

            }

        }
        if (comm.equals("querys")) {
            UserServiceImpl usi = new UserServiceImpl();
            String id = request.getParameter("id");
            int ids = Integer.parseInt(id);
            User us = null;
            try {
                us = usi.findByidUserInfo(ids);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (us != null) {
                request.setAttribute("us", us);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } else {

            }

        }
        if(comm.equals("del")){
            UserServiceImpl usi=new UserServiceImpl();
            String id=request.getParameter("id");
            int ids=Integer.parseInt(id);
            boolean flang= false;
            try {
                flang = usi.delUser(ids);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(flang){
                response.sendRedirect("list.jsp");
            }
        }
        if (comm.equals("update")) {
            //得到用户修改的数据
            UserServiceImpl usi = new UserServiceImpl();
            String id = request.getParameter("id");
            int ids = Integer.parseInt(id);
            String name = request.getParameter("username");
            String pass = request.getParameter("password");
            String sex = request.getParameter("sex");
            User us = new User();
            us.setId(ids);
            us.setUsername(name);
            us.setPassword(pass);
            us.setSex(sex);
            boolean flang = true;
            try {
                flang = usi.updateUser(us);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (flang) {
                response.sendRedirect("list.jsp");
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
    }
}

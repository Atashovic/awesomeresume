package com.company.resume.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserInfoController", urlPatterns = {"/userinfo"})
public class UserInfoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



            Integer userId = Integer.parseInt(request.getParameter("id"));
            UserDaoInter userdao = Context.instanceUserDao();
            User u = userdao.getById(userId);

            request.setAttribute("user", u);
            request.getRequestDispatcher("userinfo.jsp").forward(request,response);
    }
}

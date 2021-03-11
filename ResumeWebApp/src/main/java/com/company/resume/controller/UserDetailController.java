/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.Context;

/**
 *
 * @author jabir.amirkhanli
 */
@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

    UserDaoInter userdao = Context.instanceUserDao();
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.valueOf(request.getParameter("id"));
        String action = request.getParameter("action");
        if (action.equals("update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            User user = userdao.getById(id);
            user.setName(name);
            user.setSurname(surname);
            user.setAddress(address);
            user.setEmail(email);
            user.setPhone(phone);

            userdao.updateUser(user);
        } else if (action.equals("delete"))
        {
            userdao.removeUser(id);
        }


//        response.getOutputStream().println("successfully completed");
//        response.getOutputStream().close();
        
        response.sendRedirect("users");
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalAccessException("id is not specified");
            }
            Integer userId = Integer.parseInt(request.getParameter("id"));
            UserDaoInter userdao = Context.instanceUserDao();
            User u = userdao.getById(userId);
            if (u == null) {
                throw new IllegalAccessException("There is no user with this id");
            }

            request.setAttribute("owner", true);
            request.setAttribute("user", u);
            request.getRequestDispatcher("userdetail.jsp").forward(request,response);
        } catch (Exception ex)
        {
            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage());
        }

    }

}

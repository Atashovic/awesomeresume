/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.firstwebapp;

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
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    UserDaoInter userdao = Context.instanceUserDao();
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        System.out.println("name" + name);
        System.out.println("surname" + surname);
        System.out.println("address" + address);
        System.out.println("phone" + phone);
        System.out.println("email" + email);
        
        User user = userdao.getById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAddress(address);
        user.setEmail(email);
        user.setPhone(phone);
        
        userdao.updateUser(user);
        
//        response.getOutputStream().println("successfully completed");
//        response.getOutputStream().close();
        
        response.sendRedirect("user.jsp");
        
    }

}

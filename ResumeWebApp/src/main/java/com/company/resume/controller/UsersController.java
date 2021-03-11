/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.List;

/**
 *
 * @author jabir.amirkhanli
 */
@WebServlet(name = "UsersController", urlPatterns = {"/users"})
public class UsersController extends HttpServlet {

    UserDaoInter userdao = Context.instanceUserDao();
   



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDaoInter userdao = Context.instanceUserDao();


        request.getRequestDispatcher("users.jsp").forward(request,response);


    }

}

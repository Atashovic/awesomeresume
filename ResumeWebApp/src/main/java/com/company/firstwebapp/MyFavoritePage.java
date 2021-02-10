/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.firstwebapp;

import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "MyFavoritePage", urlPatterns = {"/MyFavoritePage"})
public class MyFavoritePage extends HttpServlet {
    
    private SkillDaoInter skilldao = Context.instanceSkillDao();
    private int i = 0;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            
            throws ServletException, IOException
    {
        
        try {
            
            i = i + 1;

//            
//            response.setContentType("text/html;charset=UTF-8");
//            int id = Integer.parseInt(request.getParameter("id"));
//            User u = userdao.getById(id);
             String requestStr = getBody(request);
            System.out.println("request = " + requestStr);
//            List<User> users = userdao.getAll();
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MyFavoritePage</title>");
                out.println("</head>");
                out.println("<body>");
                out.println(skilldao.getAll() + "<br>");
                out.println("i = " + i);
//            out.println("<h1>Servlet MyFavoritePage at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }   catch (Exception ex) {
            Logger.getLogger(MyFavoritePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try {
            String requestStr = getAllDataFromRequest(request);
            System.out.println("request = " + requestStr);
            
            String name = String.valueOf(request.getParameter("name"));
            
            Skill s = new Skill(0,name);
            boolean b = skilldao.insertSkill(s);
            
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MyFavoritePage</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("I got Post Req");
                out.println("user inserted: " + s + "<br>");
                out.println("</body>");
                out.println("</html>");
            }
            
        }   catch (Exception ex) {
            Logger.getLogger(MyFavoritePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
        try {
            String requestStr = getBody(request);
            System.out.println(requestStr);
            
//            String name = String.valueOf(request.getParameter("name"));
//            
//            Skill s = new Skill(0,name);
//            boolean b = skilldao.insertSkill(s);
            
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MyFavoritePage</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("I got Putkkkk Req");
//                String requestStr = getAllDataFromRequest(request);
////            System.out.println("request = " + requestStr);
//                out.println("request = " + requestStr);
                out.println("</body>");
                out.println("</html>");
            }
            
        }   catch (Exception ex) {
            Logger.getLogger(MyFavoritePage.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

   
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
    }
    
    public static String getAllDataFromRequest(HttpServletRequest request) throws Exception {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();

        return body;
    }
    
    
    
public static String getBody(HttpServletRequest request) throws IOException {

    String body = null;
    StringBuilder stringBuilder = new StringBuilder();
    BufferedReader bufferedReader = null;

    try {
        InputStream inputStream = request.getInputStream();
        if (inputStream != null) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            char[] charBuffer = new char[128];
            int bytesRead = -1;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                stringBuilder.append(charBuffer, 0, bytesRead);
            }
        } else {
            stringBuilder.append("");
        }
    } catch (IOException ex) {
        throw ex;
    } finally {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                throw ex;
            }
        }
    }

    body = stringBuilder.toString();
    return body;
}


}

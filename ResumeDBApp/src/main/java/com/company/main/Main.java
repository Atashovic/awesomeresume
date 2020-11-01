/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.bean.User;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author jabir.amirkhanli
 */
public class Main {
    
    
 
    
    public static void main(String[] args) throws Exception {
        UserDaoInter userdao = new UserDaoImpl();
        
        User u = new User(0,"Cabir", "Amirkhanli","+994552475728","cabir1993@bk.ru");
        userdao.addUser(u);
        
        
        List<User> list = userdao.getAll();
        System.out.println("list"+ list);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jabir.amirkhanli
 */
public abstract class AbstractDAO {
    
      public Connection connect() throws Exception {


        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "current2020";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
    
    
}

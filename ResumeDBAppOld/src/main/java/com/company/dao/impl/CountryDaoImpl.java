/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jabir.amirkhanli
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {
    
    
    private Country getCountry(ResultSet rs) throws Exception
    {
 
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String nationality = rs.getString("nationality");
            
            return new Country(id,name, nationality);
        
    }

    @Override
    public List<Country> getAll() {
        
        List<Country> result = new ArrayList<>();
               
        try (Connection c = connect()) {
            
        Statement stmt = c.createStatement();
        stmt.execute("select c.* from country c");
        ResultSet rs = stmt.getResultSet();
        
        while(rs.next())
        {
            Country cn = getCountry(rs);
            
            result.add(cn);
        }    
                          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return result;
        
    }


    
}

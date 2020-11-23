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
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.EmploymentHistory;
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
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    
  private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception
    {
 
            String header = rs.getString("header");
            String jodDescription = rs.getString("job_description");
            Date beginDate = rs.getDate("begin_date");
            Date endDate = rs.getDate("end_date");
            int userId = rs.getInt("user_id");
            
            EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, jodDescription, new User(userId));
            
            return emp;
        
    }
    
    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        
        List<EmploymentHistory> result = new ArrayList<>();
               
        try (Connection c = connect()) {
            
        PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id = ? ");
        
        stmt.setInt(1, userId);
        stmt.execute();
        ResultSet rs = stmt.getResultSet();
        
        while(rs.next())
        {
            EmploymentHistory emp = getEmploymentHistory(rs);
            
            result.add(emp);
        }    
                       
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return result;        
        
    }
}

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
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception
    {
 
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String profileDesc = rs.getString("profile_description");
            int nationalityId = rs.getInt("nationality_id");
            int birthplaceId = rs.getInt("birthplace_id");
            String nationalityStr = rs.getString("nationality");
            String birthplaceStr = rs.getString("birthplace");
            Date birthdate = rs.getDate("birthdate");
            
            Country nationality = new Country(nationalityId,null,nationalityStr);
            Country birthplace = new Country(birthplaceId,birthplaceStr,null); 
            
            return new User(id,name,surname,phone,email, address, profileDesc, birthdate, nationality,birthplace);
        
            
    }
    

    
    @Override
    public List<User> getAll() {
        
        List<User> result = new ArrayList<>();
               
        try (Connection c = connect()) {
            
        Statement stmt = c.createStatement();
        stmt.execute("select u.*, n.nationality,"
                + "c.name as birthplace from user u"
                + " left join country n on u.nationality_id = n.id"
                + " left join country c on u.birthplace_id = c.id");
        ResultSet rs = stmt.getResultSet();
        
        while(rs.next())
        {
            User u = getUser(rs);
            
            result.add(u);
        }    
        
        
        System.out.println(c.getClass().getName());                  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return result;

    }

    @Override
    public boolean updateUser(User u) {
        

     try (Connection c = connect()) { 
        
           PreparedStatement stmt = c.prepareStatement("update user set name = ?,surname = ?"
                 + ", phone = ?, "
                 + " email = ?, "
                   + " address = ?, "
                   + " profile_description = ?, "
                   + " birthdate = ?, "
                   + " birthplace_id = ? "
                   + " where id = ?");
           stmt.setString(1, u.getName());
           stmt.setString(2, u.getSurname());
           stmt.setString(3, u.getPhone());
           stmt.setString(4, u.getEmail());
           stmt.setString(5, u.getAddress());
           stmt.setString(6, u.getProfileDesc());
           stmt.setDate(7, u.getBirthDate());
           stmt.setInt(8, u.getBirthPlace().getId());
           stmt.setInt(9, u.getId());
           return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean removeUser(int id) {
        
        
     try (Connection c = connect()) { 
        
        Statement stmt = c.createStatement();
           return stmt.execute("delete from user where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    @Override
    public User getById(int userId) {
        
        User result = null;
               
        try (Connection c = connect()) {
            
        Statement stmt = c.createStatement();
        stmt.execute("select u.*, n.nationality,"
                + "c.name as birthplace from user u"
                + " left join country n on u.nationality_id = n.id"
                + " left join country c on u.birthplace_id = c.id"
                + " where u.id = " + userId);
        ResultSet rs = stmt.getResultSet();
        
        while(rs.next())
        {
            result = getUser(rs);
        }    
        
                        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return result;        
       
    }

    @Override
    public boolean addUser(User u) {
       
             try (Connection c = connect()) { 
        
           PreparedStatement stmt = c.prepareStatement("insert into user (name,surname,phone,email,address "
                   + "profile_description) values(?,?,?,?,?)");
           stmt.setString(1, u.getName());
           stmt.setString(2, u.getSurname());
           stmt.setString(3, u.getPhone());
           stmt.setString(4, u.getEmail());
           stmt.setString(5, u.getAddress());
           stmt.setString(6, u.getProfileDesc());
           return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }


    
}

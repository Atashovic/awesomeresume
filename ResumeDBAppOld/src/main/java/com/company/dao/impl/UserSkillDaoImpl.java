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
import com.company.dao.inter.UserSkillDaoInter;
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
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    
//  private UserSkill getUserSkill(ResultSet rs) throws Exception
//    {
// 
//            int userId = rs.getInt("id");
//            int skillId = rs.getInt("skill_id");
//            String skillName = rs.getString("skill_name");
//            int power = rs.getInt("power");
//            
//            
//            return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power );
//        
//    }
//    
//    @Override
//    public List<UserSkill> getAllSkillByUserId(int userId) {
//        
//        List<UserSkill> result = new ArrayList<>();
//               
//        try (Connection c = connect()) {
//            
//        PreparedStatement stmt = c.prepareStatement("select "
//                + "u.*, "
//                +  "us.skill_id, "
//                + " s.name as skill_name, "
//                + "us.power "
//                + "from "
//                + "user_skill us "
//                + "left join user u on us.user_id = u.id "
//                + "left join skill s on us.skill_id = s.id "
//                + " where "
//                + "us.user_id = ? ");
//        
//        stmt.setInt(1, userId);
//        stmt.execute();
//        ResultSet rs = stmt.getResultSet();
//        
//        while(rs.next())
//        {
//            UserSkill u = getUserSkill(rs);
//            
//            result.add(u);
//        }    
//                       
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        
//        return result;        
//        
//    }
    
    
    public UserSkill getUserSkill(ResultSet rs) throws SQLException {

        int userSkillId = rs.getInt("user_skill_id");

        int userId = rs.getInt("id");
        int skill_id = rs.getInt("skill_id");
        String skill_name = rs.getString("skill_name");
        int power = rs.getInt("power");
        UserSkill us = new UserSkill(userSkillId, new User(userId), new Skill(skill_id, skill_name), power);
        System.out.println(us);
        return us;

    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        List<UserSkill> list = new ArrayList<>();
        Connection conn;
        try {
            conn = connect();

            PreparedStatement stmt = conn.prepareStatement("SELECT "
                    + " us.id as user_skill_id,"
                    + " u.*,"
                    + " us.skill_id,s.name AS Skill_name ,"
                    + " us.power "
                    + " FROM "
                    + " user_skill us "
                    + " LEFT JOIN user u ON us.user_id=u.id "
                    + " LEFT JOIN skill s ON us.skill_id=s.id "
                    + " WHERE us.user_id = ? ");
            stmt.setInt(1, id);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                UserSkill us = getUserSkill(rs);
                list.add(us);

            }
        } catch (Exception ex) {

        }
        return list;
    }

    public boolean insertUserSkill(UserSkill u) {
        Connection conn;
        boolean b = true;
        try {
            conn = connect();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO user_skill (skill_id , user_id ,power) VALUES (? , ? ,  ? ) ");

            stmt.setInt(1, u.getSkill().getId());
            stmt.setInt(2, u.getUser().getId());
            stmt.setInt(3, u.getPower());

            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }

    public boolean updateUserSkill(UserSkill u) {
        Connection conn;
        boolean b = true;
        try {
            conn = connect();
            PreparedStatement stmt = conn.prepareStatement("UPDATE user_skill SET skill_id = ? , user_id =? ,power =?  WHERE id = ? ");

            stmt.setInt(1, u.getSkill().getId());
            stmt.setInt(2, u.getUser().getId());
            stmt.setInt(3, u.getPower());

            stmt.setInt(4, u.getId());

            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeUserSkill(int id) {
        Connection conn;
        try {
            conn = connect();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM user_skill  WHERE ID = ?");
            stmt.setInt(1, id);
            System.out.println("id :" + String.valueOf(id));
            return stmt.execute();

        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
    
}

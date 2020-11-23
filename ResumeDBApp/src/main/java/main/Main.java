/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.company.entity.User;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
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
//        UserSkillDaoInter dao = Context.instanceUserSkillDao();
        
//        EmploymentHistoryDaoInter dao = Context.instanceEmploymentHistoryDao();

//           CountryDaoInter dao = Context.instanceCountryDao();


//        System.out.println(userdao.getAll());
//        System.out.println(dao.getAll());
        
        SkillDaoInter dao = Context.instanceSkillDao();


        System.out.println(dao.getAll());
        
    }
    
}

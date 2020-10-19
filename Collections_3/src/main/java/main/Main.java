/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bean.Student;
import bean.Teacher;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jabir.amirkhanli
 */
public class Main {
    
    public static void main(String[] args) {
        HashMap<Teacher, Student> students = new HashMap<>();
        Teacher teacher  = new Teacher(1,"Jabir","Amirkhanli");
        Teacher teacher2  = new Teacher(2,"Elshen","Baghirov");
        
        students.put(teacher,new Student(1,"student1", "student1"));
        students.put(teacher2, new Student(2,"student1","student2"));
        
        System.out.println("get is called");
        students.get(teacher2);
        
        
    }
    
}

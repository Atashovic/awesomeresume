/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author jabir.amirkhanli
 */
public class Teacher extends Person {

    public Teacher(int id, String name, String surname) {
        super(id, name, surname);
    }
    
    @Override
    public int hashCode ()
    {
        System.out.println("teacher hashcode="+super.getName());
        return 1;
    }
    
}

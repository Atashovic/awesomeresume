/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.generics;

/**
 *
 * @author jabir.amirkhanli
 */
public class Container<E> {
    
    private E stored;

    public Container(E obj) {
        this.stored = obj;
    }
    
    
        
    public E castAndReturn(E passed)
    {
        System.out.println("passed"+ passed.getClass().getName());
        System.out.println("stored"+ stored.getClass().getName());
        return (E) passed;
    }
    
    public E doo()
    {
        return stored;
    }
    
}

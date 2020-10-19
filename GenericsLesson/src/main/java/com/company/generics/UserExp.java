/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.generics;

import java.util.Iterator;

/**
 *
 * @author jabir.amirkhanli
 */
public class UserExp implements Iterable{
    
    

    @Override
    public Iterator iterator() {
        Iterator<Object> iter = new Iterator<>()
        {
            @Override
            public boolean hasNext() {
               return true;
            }

            @Override
            public Object next() {
                return new Object();
            }
        };
        
        return iter;
                
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author jabir.amirkhanli
 */
public class Main {
    
    public static void main(String[] args)
    {
        Container<User4> container = new Container<>(new User4());
        
        method1(container);
        
        ArrayList 
        Collection gh = Collections.synchronizedCollection(c);
        
    }
    
    public static void method1(Container<? extends User3> container)
    {
        User5 u = container.doo();
    }

 
    
}

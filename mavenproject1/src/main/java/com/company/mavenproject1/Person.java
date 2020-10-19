/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.mavenproject1;

import bean.WritingStyle;
import lombok.Data;
import lombok.SneakyThrows;

/**
 *
 * @author jabir.amirkhanli
 */

@Data
public class Person {
    
    @WritingStyle
    private String name;
    private String surname;
    
    @SneakyThrows
    public void foo(int a)
    {
        if (a > 9) {
            throw new Exception();
        }
    }
    
    
}

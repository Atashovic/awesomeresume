/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.thread.Base;
import main.thread.MyConsumer;
import main.thread.MyProducer;

/**
 *
 * @author jabir.amirkhanli
 */
public class Main {
    public static void main(String[] args)
    {
//        MyProducer p1 = new MyProducer();
//        MyConsumer m1 = new MyConsumer("Person1");
//        MyConsumer m2 = new MyConsumer("Person2");
//        MyConsumer m3 = new MyConsumer("Person3");
//        MyConsumer m4 = new MyConsumer("Person4");
//        MyConsumer m5 = new MyConsumer("Person5");
//        
//        p1.start();
//        m1.start();
//        m2.start();
//        m3.start();
//        m4.start();
//        m5.start();
        
        Thread[] threads = new Thread[100];
        
        for(int i = 0; i < 100; i++)
        {
            threads[i] = new Thread(new MyConsumer("Test"));
        }
        
        for(int i = 0; i < 100; i++)
        {
            threads[i].start();
        }
        
        System.out.println(Base.a);
     }
    
}

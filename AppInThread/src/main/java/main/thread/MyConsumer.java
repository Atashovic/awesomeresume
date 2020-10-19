/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jabir.amirkhanli
 */
public class MyConsumer extends Thread{
    
    private String name;
    
    public MyConsumer(String name)
    {
        this.name = name;
    }
    
    @Override
    public void run()
    {
//        try {
            //      while(true)
//      {
//        int lastindex = Base.list.size()-1;
//        System.out.println("last index= " + lastindex);
//        
//        if(lastindex > -1)
//        {
//          String s = Base.list.remove(lastindex);  
//          System.out.println("s= " + s);
//        }
//      }

//Thread.sleep(20);


//        System.out.println("2");
//        System.out.println("3");
//        System.out.println("4");
//        } catch (InterruptedException ex) {
//            Logger.getLogger(MyConsumer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        Base.a++;
    }
}

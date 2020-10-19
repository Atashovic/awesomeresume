/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import fileUtility.FileUtility;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author jabir.amirkhanli
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
      

        Scanner sc = new Scanner(System.in);
        
//        Name and Surname
        System.out.println("Please enter name and surname: ");
        
        String nmAndSrnm = sc.next();
                
        
            
        
        
//        File (Photo)
        Scanner sc2 = new Scanner(System.in);    
        System.out.println("Zehmet olmasa gondermek istediyiniz faylin yerleshdiyi kecidi qeyd edin: ");
        
         String selectedFile = sc2.next();
        
        
//        IP and Port
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Shekli gondermek istediyiniz shexsin(serverin) ip və portunu daxil edin: ");
               
        String selectedIPAndPort = sc3.next(); 
        
        String[] arr = selectedIPAndPort.split(":");

        String ip = arr[0];

        int port = Integer.parseInt(arr[1]);
        
//        Menu selectedMenu =  Menu.find(selectedMenuNumber);
//        selectedMenu.process();


        Socket socket = new Socket(ip,port);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        


        byte[] bytes = FileUtility.readBytes(selectedFile);
//        outputStream.write("Salam Server, necesen ? ".getBytes());
          
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
//        outputStream.write(bytes);

        System.out.println("Shekil ugurla gonderildi");
        socket.close();
    }
    
}

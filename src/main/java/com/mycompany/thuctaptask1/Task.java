/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.thuctaptask1;

import java.util.Timer;
import java.util.logging.Level;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;


/**
 *
 * @author tiendungmai
 */
public class Task {
    public static Logger logger =   LoggerFactory.getLogger(Task.class);
    public static void main(String[] args) {
            Timer time = new Timer();
            int userpre =1 , usernext, cout=1;
            ThreadParse tp  = new ThreadParse();
            while(true){
            try {
            usernext = tp.call();
            if((usernext - userpre)/userpre>5/10){
                logger.info(String.valueOf(usernext));
                cout=1;
                userpre= usernext;
            }
            else if(cout ==6){
                logger.debug(String.valueOf(usernext));
                cout=1;
                userpre= usernext;
            }
            else{
                System.out.println("Khong ghi");
                cout++;
            }
            
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.thuctaptask1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/**
 *
 * @author tiendungmai
 */
public class ThreadParse implements Callable<Integer>{
    public ThreadParse() {
    }

    @Override
    public Integer call() throws Exception {
        int user=0;
        URL url = new URL("http://news.admicro.vn:10002/api/realtime?domain=kenh14.vn");
        
        URLConnection  uRLConnection = url.openConnection();
        HttpURLConnection httpURLConnection= null;
        if(uRLConnection instanceof HttpURLConnection){
            httpURLConnection = (HttpURLConnection) uRLConnection;
        }
        else{
            System.out.println("Dia chi url khong dung");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String result ="";
        String current;
        while((current = br.readLine())!= null){
            result += current;
        }
        System.out.println(result);
        JSONObject jSONObject = new JSONObject(result);
        user = jSONObject.getInt("user");
        
        Thread.sleep(2000);
        return user;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void run() {
        ThreadParse tp = new ThreadParse();
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

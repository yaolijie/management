package com.liji.managementSystem.h2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class H2DBFunctionExt {


    public static String uuid(){
        return UUID.randomUUID().toString();
    }

    public static String now(){
        return new Date().toLocaleString();
    }

    public static String getIp(){
        try{
            InetAddress address=InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String date_format(String date,String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Date temp=null;
        if(date!=null){
            try{
                temp=sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return sdf.format(temp);
    }


}

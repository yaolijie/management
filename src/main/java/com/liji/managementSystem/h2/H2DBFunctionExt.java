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
        if(date!=null){
            SimpleDateFormat sdf=new SimpleDateFormat(pattern);
            try{
                Date temp=sdf.parse(date);
                return sdf.format(temp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


}

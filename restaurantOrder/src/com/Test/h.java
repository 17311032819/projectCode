package com.Test;


import java.io.FileDescriptor;
import java.util.Calendar;

public class h {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        System.out.println("年: " + now.get(Calendar.YEAR));
        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("分: " + now.get(Calendar.MINUTE));
        System.out.println("秒: " + now.get(Calendar.SECOND));
        System.out.println("当前时间毫秒数：" + now.getTimeInMillis());
        System.out.println(now.getTime());
        String time= String.valueOf(now.get(Calendar.YEAR))+String.valueOf((now.get(Calendar.MONTH)+1))+String.valueOf(now.get(Calendar.DAY_OF_MONTH))+
                String.valueOf(now.get(Calendar.HOUR_OF_DAY))+String.valueOf(now.get(Calendar.MINUTE))+ String.valueOf(now.get(Calendar.SECOND));
        System.out.println(time);
    }

}

package com.Test;


import java.io.FileDescriptor;
import java.util.Calendar;

public class h {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        System.out.println("��: " + now.get(Calendar.YEAR));
        System.out.println("��: " + (now.get(Calendar.MONTH) + 1) + "");
        System.out.println("��: " + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("ʱ: " + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("��: " + now.get(Calendar.MINUTE));
        System.out.println("��: " + now.get(Calendar.SECOND));
        System.out.println("��ǰʱ���������" + now.getTimeInMillis());
        System.out.println(now.getTime());
        String time= String.valueOf(now.get(Calendar.YEAR))+String.valueOf((now.get(Calendar.MONTH)+1))+String.valueOf(now.get(Calendar.DAY_OF_MONTH))+
                String.valueOf(now.get(Calendar.HOUR_OF_DAY))+String.valueOf(now.get(Calendar.MINUTE))+ String.valueOf(now.get(Calendar.SECOND));
        System.out.println(time);
    }

}

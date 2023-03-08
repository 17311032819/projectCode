package com.email;

import java.util.Random;

import static java.lang.Thread.sleep;


public class SendCode {
    public String sendCode(String qq) throws InterruptedException {

        SendEmail sendEmail=new SendEmail();
        //设置要发送的邮箱
        sendEmail.setReceiveMailAccount(qq);
        //创建6位验证码
        String str="";

            Random random=new Random();

            for(int j=0;j<6;j++) {
                int n=random.nextInt(10);
                str+=n;
            }
            sendEmail.setInfo(str);
            try {
                sendEmail.Send();
                System.out.println("发送成功");
            } catch (Exception e) {
                e.printStackTrace();
            }

        return str;
    }

    public static void main(String[] args) throws InterruptedException {

        new SendCode().sendCode("3033774629@qq.com");
        System.out.println("");
    }
}


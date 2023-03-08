package com.email;

import java.util.Random;

public class CheckCode {

    public static String getCheckCode() {
        Random random = new Random();

        String checkCode = "";

        for (int i = 0; i < 6; i++) {
            checkCode += random.nextInt(10) ;
        }
        return  checkCode ;
    }

    public static void main(String[] args) {

        System.out.println(getCheckCode());
    }
}

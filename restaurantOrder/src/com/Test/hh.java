package com.Test;

import java.util.regex.Pattern;
import java.util.Scanner;
public class hh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String regex = "[1-9][0-9]{4,9}\\@[q][q]\\.[c][o][m]";
        if(s1.matches(regex)){
            System.out.println("’‚ «QQ” œ‰");
        }else {
            System.out.println("«Î ‰»ÎQQ” œ‰");
        }
    }
}

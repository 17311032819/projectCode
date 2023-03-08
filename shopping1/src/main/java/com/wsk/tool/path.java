package com.wsk.tool;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

public class path {
    public static void main(String[] args) {
        System.out.println(new path().getfile());
    }

    public List<String>  getfile(){

        URL url= this.getClass().getResource(".");
        String p = url.getPath();
        try {
            p= URLDecoder.decode(p, "UTF-8");
            //方法二解码路径：/E:/test/test04练  习/bin/com/fei/
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<String> pathlist= Arrays.asList(p.split("/"));
        System.out.println(pathlist.get(0));
        for (String path:pathlist){
            System.out.println(path);
        }
        String filePath;
        return pathlist;

    }
}

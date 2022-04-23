package com.yyv.meifa;

import java.util.Arrays;

public class MeifaApplicationTests {

    public static void main(String[] args) {
        MeifaApplicationTests na=new MeifaApplicationTests();
        na.show("sdasdatatafsfvxz");
    }
    public void show(String name){
                char [] cs=name.toCharArray();
        Arrays.sort(cs);
        /*for (int i=0;i<chars.length;i++){
            System.out.println(chars[i]);
        }*/
        for (int i=cs.length-1;i>=0;i--){
            System.out.println(cs[i]);
        }

    }

}

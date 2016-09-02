package com.yichli.info.wangyi;

/**
 * Created by yichli on 9/2/16.
 */
public class CommonStr {
    public String returnMaxCommonStrLength(String a, String b){
        int alen = a.length();
        int blen = b.length();
        int num = 0;
        int max = 0;
        int start = 0;
        for(int i = 0; i < alen; i++){
            for(int j = 0; j < blen; j ++){
                int start1 = i;
                int start2 = j;
                while(a.charAt(start1) == b.charAt(start2) && start1 < alen - 1 && start2 < blen - 1){
                    num ++;
                    start1++;
                    start2++;
                }
                if(num > max) {
                    max = num;
                    start = i;
                }
                else{
//                    start = 0;
                    num = 0;
                }
            }
        }
        return a.substring(start,start + max);
    }

    public static void main(String args[]){
        String a = new CommonStr().returnMaxCommonStrLength("abcdefacdd","bacfdfabcdeee");
        System.out.println(a);
    }
}

package com.leetcode;

/**
 * Created by yichli on 9/13/16.
 */
public class ZigZagConversation {
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < sb.length; i++)
            sb[i] = new StringBuffer();

        int j = 0;
        while(j < len){
            for(int index = 0; index < numRows && j < len; index++){
                sb[index].append(s.charAt(j++));
            }
            for(int index = numRows - 2; index > 0 && j < len; index--)
                sb[index].append(s.charAt(j++));
        }

        for(int i = 1; i < sb.length;i++)
            sb[0].append(sb[i]);
        return sb[0].toString();
    }

    public static void main(String[] args){
        String s = new ZigZagConversation().convert("PAYPALISHIRING",4);
        System.out.println(s);
    }
}

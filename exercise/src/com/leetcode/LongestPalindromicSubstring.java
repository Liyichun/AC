package com.leetcode;

/**
 * Created by yichli on 9/13/16.
 */
public class LongestPalindromicSubstring {
    public int maxLen;
    public int lo;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2)
            return s;
        for(int i = 0; i < s.length() - 1; i++){
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(lo,lo + maxLen);
    }
    public void extend(String s, int j, int k){
        while(k < s.length() && j >= 0 && s.charAt(k) == s.charAt(j)){
            j--;
            k++;
        }
        if(maxLen < k - j - 1){
            lo = j + 1;
            maxLen = k - j - 1;
        }

    }

    public static void main(String[] args){
       String s = new LongestPalindromicSubstring().longestPalindrome("bb");
        System.out.println(s);
    }

}

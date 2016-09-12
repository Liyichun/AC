package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.zip.CheckedInputStream;

/**
 * Created by yichli on 9/12/16.
 */
public class LongestSubstrWithoutReCha {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - j + 1);
        }
        return max;
    }


    public static void main(String args[]){
        int s = new LongestSubstrWithoutReCha().lengthOfLongestSubstring("aab");
        System.out.println(s);
    }
}

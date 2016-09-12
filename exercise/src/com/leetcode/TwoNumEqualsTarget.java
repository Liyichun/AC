package com.leetcode;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;

/**
 * Created by yichli on 9/12/16.
 */
public class TwoNumEqualsTarget {
    public void findTwoNumEqualsTarget(int[] a, int target){
        Map<Integer,Integer> result = new HashMap<Integer,Integer>();
        for(int i = 0; i < a.length; i++){
            if(result.containsKey(target - a[i])){
                System.out.println(target - a[i] + " " +  a[i] + '\n');
            }
            else{
                result.put(a[i],i);
            }
        }
    }


    public static void main(String args[]){
        int[] a = {2,4,5,6,1,3,8,7};
        new TwoNumEqualsTarget().findTwoNumEqualsTarget(a,11);
    }
}

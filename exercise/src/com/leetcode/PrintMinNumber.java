package com.leetcode;

import java.util.*;

/**
 * Created by yichli on 10/5/16.
 */
public class PrintMinNumber {
    String minValue = null;
    public String printMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0)return "";
        List<Integer> datas = new ArrayList<Integer>();
        for(int i=0;i<numbers.length;i++)
        {
            datas.add(numbers[i]);
            minValue = minValue+numbers[i];
        }
        sort(datas, new ArrayList<Integer>(), numbers.length);
        return String.valueOf(minValue);
    }

    public void sort(List<Integer> datas, List<Integer> target, int length)
    {
        if(target.size() == length)
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<target.size();i++)
            {
                sb.append(target.get(i));
            }
            if(sb.toString().compareTo(minValue)<0)
            {
                minValue = sb.toString();
            }
        }
        for(int i=0;i<datas.size();i++)
        {
            List<Integer> newDatas = new ArrayList<>(datas);
            List<Integer> newTarget = new ArrayList<>(target);

            newTarget.add(newDatas.get(i));
            newDatas.remove(i);
            sort(newDatas, newTarget, length);
        }
    }
    public static void main(String[] args){
        int[] a = {1,2,3};
        String resu = new PrintMinNumber().printMinNumber(a);
        System.out.println(resu);
    }
}

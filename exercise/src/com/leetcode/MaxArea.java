package com.leetcode;

/**
 * Created by yichli on 9/20/16.
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        int k = 0;
        while(i < j){
            max = Math.max(max,(j-i) * Math.min(height[i],height[j]));
            if(height[i] < height[j]){
                for(k = i + 1; k < j && height[k]<=height[i]; k++){}
                i = k;
            }
            else{
                for(k = j - 1; k > i && height[k]<=height[j]; k--){}
                j = k;
            }
        }
        return max;
    }
}

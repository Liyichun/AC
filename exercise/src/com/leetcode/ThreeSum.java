package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yichli on 10/4/16.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i ++){
            if(i == 0 || i > 0 && nums[i] != nums[i - 1]){

                int lo = i + 1, high = nums.length - 1, sum = 0 - nums[i];
                while(lo < high) {
                    List<Integer> list = new ArrayList<>();
                    if (nums[lo] + nums[high] == sum){
                        list.add(nums[lo]);
                        list.add(nums[i]);
                        list.add(nums[high]);
                        result.add(list);
                        while(nums[lo] == nums[lo + 1]) lo ++;
                        while(nums[high] == nums[high - 1]) high --;
                        lo ++;
                        high--;
                    }else if (nums[lo] + nums[high] < sum) lo++;
                    else
                        high --;

                }
            }

        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> re = new ThreeSum().threeSum(arr);
        for(List<Integer> r : re){
            System.out.println(r);
        }
    }

}

package com.sort;

import java.util.Arrays;

/**
 * Created by yichli on 9/26/16.
 */
public class QuickSort {

    /**
     * 考虑最坏情况下，每次 partition 将数组分为长度为 N-1 和 1 的两部分，
     * 然后在长的一边继续寻找第 K 大，此时时间复杂度为 O(N^2 )。
     * 不过如果在开始之前将数组进行随机打乱，那么可以尽量避免最坏情况的出现。
     * 而在最好情况下，每次将数组均分为长度相同的两半，运行时间 T(N) = N + T(N/2)，时间复杂度是 O(N)。
     * @param data
     * @param len
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] data, int len, int start, int end){
        if(data == null || len <= 0 || start < 0 || end >= len)
            return -1;
        int index = end; //randomInRange(start, end);
        swap(data, index, end);

        int small = start -1;
        for(index =start; index<end;index++){
            if(data[index] < data[end]){
                ++small;
                if(small != index)
                    swap(data, index, small);

            }
        }

        ++small;
        swap(data, small, end);
        System.out.println(Arrays.toString(data));
        return small;
    }

    public void swap(int[] data, int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public void sort(int[] a, int length, int start, int end){
        if(start == end)
            return;
        int pivot = partition(a, length, start, end);
        if(pivot < end)
            sort(a, length, pivot + 1, end);
        else if(pivot > start)
            sort(a, length, start, pivot - 1);
    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int[] a= {3,7,5,1,6,2,8};
        qs.sort(a, a.length, 0, a.length - 1);
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}

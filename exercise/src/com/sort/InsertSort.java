package com.sort;

/**
 * Created by yichli on 10/9/16.
 */
public class InsertSort {
    public int[] insertSort(int[] a, int n){
        for(int i = 1; i < n; i++){
            int key = a[i];
            int j = i - 1;
            while(j >= 0 && a[j] > key){
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        return a;
    }
    public static void main(String[] args){
        int[] a = {3,4,5,1,2};
        new InsertSort().insertSort(a,5);
        for(int r : a){
            System.out.print(r + " ");
        }
    }
}

package com.sort;
/**
 * Created by yichli on 9/21/16.
 */
public class Merge{
    public static int[] merge(int[] a, int lo, int mid, int hi){
        int i = lo, j = mid + 1;
        int[] aux = new int[hi + 1];
        for(int k = lo; k <= hi; k ++){
            aux[k] = a[k];
        }
        for(int m = lo; m <=hi; m++){
            //左边用尽 取右半边元素
            if(i > mid)
                a[m] = aux[j++];
            //右边用尽 取左半边元素
            else if(j > hi)
                a[m] = aux[i++];
            //右半边当前元素小于左半边当前元素 取右半边元素
            else if(aux[j] < aux[i])
                a[m] = aux[j++];
            else
                a[m] = aux[i++];
        }
        return a;
    }

    public void sort(int[] a) {

    }

    //安排多次merge
    public int[] sort(int[] a, int lo, int hi){
        if(hi <= lo)
            return a;
        int mid = lo + (hi - lo) / 2;
        sort(a,lo,mid);
        sort(a,mid + 1, hi);
        merge(a, lo, mid, hi);
        return a;
    }
    public static void main(String args[]){
        int[] a = {5,1,5,8,3,5,7,5,5,5};
        int[] result = new int[a.length];
        //result = new Merge().sort(a, 0, a.length - 1);
        for(int sz = 1; sz < a.length - 1; sz *= 2)
            for(int lo = 0; lo < a.length - sz; lo += 2 * sz){
                merge(a, lo, lo + sz - 1, Math.min(lo + sz * 2 - 1, a.length - 1));
            }
        for(int i : a){
            System.out.print(i + " ");
        }
    }

}

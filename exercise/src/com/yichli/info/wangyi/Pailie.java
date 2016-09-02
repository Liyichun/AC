package com.yichli.info.wangyi;

/**
 * Created by yichli on 8/15/16.
 */
public class Pailie {


    //no repeat
    public void getAllPermutation(int[] arr, int a){
        if(a == arr.length - 1){
            System.out.print(arr[a] + " ");
            for(int i = 0; i < a; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        else{
            for(int i = a; i < arr.length; i++){
                swap(arr,a,i);
                getAllPermutation(arr, a + 1);
                swap(arr,a,i);
            }
        }
    }


    public void getAllPermutationWithRepeat(int[] a, int[] b, int index){
        if(index == a.length){
            for(int i = 0; i < a.length; i++){
                System.out.print(b[i] + " ");
            }
            System.out.println();
        }
        else{
            for(int i = index; i < a.length; i++){
                b[i] = a[i];
                getAllPermutationWithRepeat(a, b, index + 1);
            }
        }

    }

    public void returnAllPermutationWithRepeat(int[] a,int[] b, int index){
        if(a.length == 0 || index == 0)
            return;
        else
            getAllPermutationWithRepeat(a, b, index);
    }
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String args[]){
        int a[] = {1,2,3};
        //new Pailie().getAllPermutation(a,0);
        int b[] = new int[a.length];
        new Pailie().getAllPermutationWithRepeat(a, b, 0);
    }


}

package com.yichli.info.wangyi;

import java.util.Scanner;

/**
 * 问题：
 你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。为了让问题简单，我们用正整数表示不同颜色的颜料。你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合一些颜料。混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。本着勤俭节约的精神，你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？

 分析：
 本题的数学意思是根据给出的几个数，要找到最少的数字根据规则（异或：相同为0，不同为1）可以得到给出的几个数。

 1.根据异或的原则，很容易联想到位运算。例如001,010,100便可生成1~7之间的所有数。所以，本题答案的上限应该是最大数字的位数。

 2.在给出的N个数中，可能有一些数是可以由其他数字异或生成，我们需要找到最“基础”的几个数，也就是由这几个数通过异或运算可以生成给出的所有数。那么什么是“基础”的数呢？
 回想起矩阵当中的秩：通过矩阵初等变换求出的对角线上的元素个数。反应了矩阵元素样本所张成的线性子空间的维数。
 换言之，只要求出了矩阵的秩，那么通过初等变换是可以还原原始矩阵的。

 3.根据上面的分析，我们只需要对给出的数，求出其二进制位矩阵，然后做高斯消元，最后得到秩的个数即为需要求的最少的数字个数
 */

/**
 * Created by yichli on 8/13/16.
 */
public class ColorNum {
    //计算二进制矩阵
    public int[][] getBitArray(int[] arr){
        int n = arr.length;
        int bitArr[][] = new int[n][32];
        for(int i = 0; i < n; i++){
            for(int j = 31; j >= 0 && arr[i] > 0; j--){
                bitArr[i][j] = arr[i] & 1;
                arr[i] >>= 1;
            }
        }
        return bitArr;
    }

    //改变两行的位置
    public int[][] changeLine(int[][] arr, int m, int n){
        for(int i = 0; i < arr[0].length; i ++){
            int temp = arr[m][i];
            arr[m][i] = arr[n][i];
            arr[n][i] = temp;
        }
        return arr;
    }
    public int getColorNum(int[] arr){
        int k = 0;
        int n = arr.length,
            col = 0;
        int bitArr[][] = getBitArray(arr);

        //高斯消元

        for(col = 0; col < 32 && k < n; col++, k++){
            int i = 0;
            for(i = k; i < n && bitArr[i][col] == 0; i++);
            if(i == n){
                k--;
                continue;
            }
            bitArr = changeLine(bitArr, k, i);
            for(int j = i + 1; j < n; j++){
                if(bitArr[j][col] == 0)
                    continue;
                for(int p = col; p < 32; p++){
                    bitArr[j][p] = bitArr[j][p] ^ bitArr[k][p];
                }
            }
        }
        return k;
    }
    public static void main(String args[]){
        int [] arr = {1,3,7};
        new ColorNum().getBitArray(arr);
    }
}

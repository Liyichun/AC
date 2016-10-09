package com.leetcode;

/**
 * Created by yichli on 9/17/16.
 */
public class MyAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        int sum = 0;
        int code = 1;
        boolean flag = true;
        if(str.equals("") || str == null)
            return 0;
        else{
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) >= '0' && str.charAt(i) <='9')
                    sum += (str.charAt(i) - '0') * ((str.length() - 1 - i) == 0 ? 1 : Math.pow(10,(str.length() - 1 - i)));

                else if(str.charAt(i) == '-' || str.charAt(i) == '+') {
                    if(flag){
                        if(str.charAt(i) == '-'){
                            code = -code;
                            flag = !flag;
                        }
                        else if(str.charAt(i) == '+'){
                            flag = !flag;
                        }
                    }
                    else
                        return 0;
                }
                else{
                    int m;
                    m = (int)Math.pow(10,(str.length() - i));

                    return  sum / m * code;
                }

            }

            return code * sum;
        }
    }

    public static void main(String args[]){
        int a = new MyAtoi().myAtoi("   -0012a45");
        System.out.print(a);
    }
}

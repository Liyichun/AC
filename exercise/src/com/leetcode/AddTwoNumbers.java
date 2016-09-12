package com.leetcode;

/**
 * Created by yichli on 9/12/16.
 */
public class AddTwoNumbers {


    public NodeList addTwoNumbers(NodeList l1, NodeList l2){
        NodeList c1 = l1;
        NodeList c2 = l2;
        NodeList s = new NodeList(0);
        NodeList d = s;
        int sum = 0;
        while(c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.value;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.value;
                c2 = c2.next;
            }
            d.next = new NodeList(sum % 10);
            d = d.next;
        }
        if(sum / 10 == 1){
            d.next = new NodeList(1);
        }
        return s.next;
    }

    public static void main(String args[]){
        NodeList l1 = new NodeList(2);
        NodeList l2 = new NodeList(4);
        NodeList l3 = new NodeList(3);
        NodeList l4 = new NodeList(5);
        NodeList l5 = new NodeList(6);
        NodeList l6 = new NodeList(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        l4.next = l5;
        l5.next = l6;
        l6.next = null;
        NodeList d = new AddTwoNumbers().addTwoNumbers(l1,l4);
        while(d != null){
            if(d.next != null)
                System.out.print(d.value + "->");
            else
                System.out.print(d.value);
            d = d.next;
        }

    }
}

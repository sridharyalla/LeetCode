package org.sridhar.leetcode;


//    Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
//
//    Note:
//    The length of num is less than 10002 and will be ≥ k.
//    The given num does not contain any leading zero.
//    Example 1:
//
//    Input: num = "1432219", k = 3
//    Output: "1219"
//    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//    Example 2:
//
//    Input: num = "10200", k = 1
//    Output: "200"
//    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//    Example 3:
//
//    Input: num = "10", k = 2
//    Output: "0"
//    Explanation: Remove all the digits from the number and it is left with nothing which is 0.


public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        StringBuffer sb  = new StringBuffer(num);

        for(int j = 0; j < k; j++){
            int i=0;
            while (i < sb.length()-1 && sb.charAt(i) <= sb.charAt(i+1)){
                i++;
            }
            sb.deleteCharAt(i);
        }

        while (sb.length()!=0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString().equals("") ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits p = new RemoveKDigits();
        System.out.println(p.removeKdigits("112", 1));
    }
}

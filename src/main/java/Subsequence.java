//https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
//392. Is Subsequence


import java.util.Stack;

public class Subsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println("is subsequence actual: "+isSubsequence(s, t)+" expected true");

        String s1 = "axc";
        String t1 = "ahbgdc";
        System.out.println("is subsequence actual: "+isSubsequence(s1, t1)+" expected false");

        String s2 = "acb";
        String t2 = "ahbgdc";
        System.out.println("is subsequence actual: "+isSubsequence(s2, t2)+" expected false");
    }

    public static boolean isSubsequence(String s, String t){
        Stack<Character> stack = new Stack<>();
        for(char car : s.toCharArray()){
            stack.push(car);
        }
        for (int i=t.length()-1; i>=0; i--){
            char carToEvaluate = t.charAt(i);
            if (stack.isEmpty()) return true;
            if (carToEvaluate == stack.peek()){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
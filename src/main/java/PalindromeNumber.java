//9. Palindrome Number
//https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 123;
        System.out.println(isPalindrome(number));
    }

    public static boolean isPalindrome(int x){
        String val = String.valueOf(x);
        int j = val.length()-1;
        for (int i=0; i<val.length(); i++)
        {
            if(val.charAt(i)!=val.charAt(j)) return false;
            j--;
        }
        return true;
    }
}

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
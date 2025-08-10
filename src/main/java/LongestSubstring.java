import java.util.HashMap;
import java.util.Map;

//3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length()<=1) return s.length();

        Map<Character, Integer> seenMap = new HashMap<>();
        int leftPointer = 0;
        int longest = 0;
        for (int rigthPointer = 0; rigthPointer<s.length(); rigthPointer++){
            char currentChar = s.charAt(rigthPointer);
            if(seenMap.containsKey(currentChar) && seenMap.get(currentChar)>=leftPointer){
                leftPointer = seenMap.get(currentChar) + 1;
            }
            seenMap.put(currentChar, rigthPointer);
            longest = Math.max(longest, rigthPointer-leftPointer+1);
        }
        return longest;
    }
}

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
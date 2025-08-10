//242. Valid Anagram
//https://leetcode.com/problems/valid-anagram/submissions/1642563376/

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("a"+('a'-'a'));
        System.out.println(isAnagram(s,t));
        System.out.println(isAnagramOptimalSolution(s,t));
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] counts = new int[26];

        for (int index = 0; index < s.length(); index++) {
            counts[s.charAt(index) - 'a']++;
            counts[t.charAt(index) - 'a']--;
        }
        //Arrays.stream(counts).boxed().collect(Collectors.toSet()).contains(1);
        //IntStream.of(counts).anyMatch(count -> count!=0);
        return Arrays.stream(counts).noneMatch(count -> count != 0);
    }

    public static boolean isAnagramOptimalSolution(String s, String t){
        char [] word1 = s.toCharArray();
        char[] word2 = t.toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1,word2);
    }
}

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

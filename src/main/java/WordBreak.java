//https://leetcode.com/problems/word-break/submissions/1751489163/
//139. Word Break

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {

        String s1 = "leetcode";
        List<String> wordDict1 = List.of("leet","code");
        String s2 = "applepenapple";
        List<String> wordDict2 = List.of("apple","pen");
        String s3 = "catsandog";
        List<String> wordDict3 = List.of("cats","dog","sand","and","cat");
        String s4 = "abcd";
        List<String> wordDict4 = List.of("a","abc","b","cd");
        String s5 = "bb";
        List<String> wordDict5 = List.of("a","b","bbb","bbbb");

        System.out.println(wordBreak(s1, wordDict1));
        System.out.println(wordBreak(s2, wordDict2));
        System.out.println(wordBreak(s3, wordDict3));
        System.out.println(wordBreak(s4, wordDict4));
        System.out.println(wordBreak(s5, wordDict5));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

//        StringBuilder sb = new StringBuilder();
//        char car = s.charAt(0);
//        for (String word : wordDict){
//             sb.append(word);
//        }
//        String composeWord = sb.toString();
//        if (s.equals(composeWord) || s.contains(composeWord) || composeWord.contains(s)) return true;
//        return false;

        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; //base case: string vacio siemore es valido

        for (int i = 1; i <=s.length(); i++) {
            for (int j =0; j<i; j++){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[s.length()];
    }

}
/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
* */
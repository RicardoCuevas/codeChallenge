//14. Longest Common Prefix
//https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        String[] s1 = {"dog","racecar","car"};
        String[] s2 = {"interview","internet","internal","interval"};
        String[] s3 = {"apple","banana","carrot"};
        String[] s4 = {"same","same","same"};
        String[] s5 = {"broom","brother","bronze"};
        String[] s6 = {"solitary"};
        String[] s7 = {"","empty","empire"};
        String[] s8 = {"Case","Casual","castle"};
        String[] s9 = {"car","carpet","carbon","cargo"};
        String[] s10 = {"","start","stack"};
        System.out.println("Actual Result: "+longestCommonPrefix(s)  +" Expected Result: fl");
        System.out.println("Actual Result: "+longestCommonPrefix(s1) +" Expected Result: ");
        System.out.println("Actual Result: "+longestCommonPrefix(s2) +" Expected Result: inter");
        System.out.println("Actual Result: "+longestCommonPrefix(s3) +" Expected Result: ");
        System.out.println("Actual Result: "+longestCommonPrefix(s4) +" Expected Result: same");
        System.out.println("Actual Result: "+longestCommonPrefix(s5) +" Expected Result: bro");
        System.out.println("Actual Result: "+longestCommonPrefix(s6) +" Expected Result: solitary");
        System.out.println("Actual Result: "+longestCommonPrefix(s7) +" Expected Result: ");
        System.out.println("Actual Result: "+longestCommonPrefix(s8) +" Expected Result: Cas");
        System.out.println("Actual Result: "+longestCommonPrefix(s9) +" Expected Result: car");
        System.out.println("Actual Result: "+longestCommonPrefix(s10)+" Expected Result: ");
    }

    public static String longestCommonPrefix(String[] strs){
        if (strs==null || strs.length==0) return "";
        String firstWord = strs[0];
        for (int index=0; index<firstWord.length(); index++){
            char car = firstWord.charAt(index);
            for(int j=1; j<strs.length; j++){
                if(index==strs[j].length() || strs[j].charAt(index)!=car){
                    return firstWord.substring(0,index);
                }
            }
        }
        return firstWord;
    }
}

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 */
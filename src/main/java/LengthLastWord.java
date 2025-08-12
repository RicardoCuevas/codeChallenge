//58. Length of Last Word
//https://leetcode.com/problems/length-of-last-word/description/
public class LengthLastWord {

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";

        System.out.println("Actual result : "+lengthOfLastWord1(s1)+" Expected result: 5");
        System.out.println("Actual result : "+lengthOfLastWord1(s2)+" Expected result: 4");
        System.out.println("Actual result : "+lengthOfLastWord1(s3)+" Expected result: 6");
    }

    public static int lengthOfLastWord(String s1){
        if(s1 == null || s1.isEmpty()) return 0;
        String[] words = s1.trim().split(" ");
        String lastWord = words[words.length -1];
        return lastWord.length();

    }

    public static int lengthOfLastWord1(String s){
        int count = 0;
        s = s.trim();
        for(int index=s.length()-1; index>=0; index--){
            if(s.charAt(index) != ' '){
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
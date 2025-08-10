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

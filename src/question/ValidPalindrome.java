package question;

/**
 * Created by siren0413 on 1/28/14.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s){
        if(s.isEmpty()) return true;
        s = s.toLowerCase();
        int start = 0, end = s.length()-1;
        while(start < end){
            char i = s.charAt(start), j = s.charAt(end);
            if(!((i >='a' && i<='z') || (i>='0' && i<='9'))) {
                start++;
                continue;
            }
            if(!((j >='a' && j<='z') || (j>='0' && j<='9'))) {
                end--;
                continue;
            }
            if(s.charAt(start)!=s.charAt(end)) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "a.";
        System.out.println(isPalindrome(s));
    }

}

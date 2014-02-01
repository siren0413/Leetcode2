package question;

/**
 * Created by siren0413 on 1/26/14.
 */
public class PalindromeNumber {
    public static boolean checkPalindrome(int n) {
        if (n < 0) return false;
        int dev = 1;
        while (n / dev >= 10) {
            dev *= 10;
        }
        while (n > 0) {
            int head = n / dev;
            int tail = n % 10;
            if (head != tail) return false;
            n %= dev;
            n /= 10;
            dev /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome(1234564321));
    }
}

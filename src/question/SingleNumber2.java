package question;

/**
 * Created by siren0413 on 1/27/14.
 */
public class SingleNumber2 {
    public static int singleNumber(int[] A) {
        int bit = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum += (A[j] & (1 << i)) >> i;
            }
            bit |= (sum % 3 == 0 ? 0 : 1) << i;  // in this case, the one can appear either once or twice.
        }
        return bit;
    }

    public static void main(String[] args) {
        int[] A = {2, 2, 3, 2};
        System.out.println(singleNumber(A));
    }
}

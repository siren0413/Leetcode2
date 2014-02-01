package question;

/**
 * Created by siren0413 on 1/27/14.
 */
public class SingleNumber {
    public static int singleNumber(int[] A){
        int bit = 0;
        for(int i = 0; i < A.length; i++){
            bit ^= A[i];
        }
        return bit;
    }

    public static void main(String[] args){
        int[] A = {1,2,3,4,3,2,1};
        System.out.println(singleNumber(A));
    }
}

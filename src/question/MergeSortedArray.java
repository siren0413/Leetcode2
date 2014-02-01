package question;

import java.util.Arrays;

/**
 * Created by siren0413 on 1/30/14.
 */
public class MergeSortedArray {
    public static void merge(int[] A, int m, int[] B, int n) {
        System.arraycopy(A, 0, A, n, m);
        int a = n, b = 0, i = 0;
        while (a < m + n && b < n) A[i++] = A[a] <= B[b] ? A[a++] : B[b++];
        while (b < n) A[i++] = B[b++];
    }

    public static void merge2(int[] A, int m, int[] B, int n) {
        int i = m + n - 1;
        m--;n--;
        while (m >= 0 && n >= 0) A[i--] = A[m] > B[n] ? A[m--] : B[n--];
        while (n >= 0) A[i--] = B[n--];
    }


    public static void main(String[] args) {
        int[] A = {2, 0};
        int[] B = {1};
        merge2(A, 1, B, 1);
        System.out.println(Arrays.toString(A));
    }
}

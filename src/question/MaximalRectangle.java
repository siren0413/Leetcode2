package question;

/**
 * Created by siren0413 on 1/31/14.
 */
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j]=='1'){
                    int area = maximalRectangleHelper(matrix,i,j);
                    if( area > max) max = area;
                }
            }
        }
        return max;
    }

    private static int maximalRectangleHelper(char[][] matrix, int i, int j) {
        int max = 1;
        for (int m = i; m < matrix.length; m++) {
            int sum = 0;
            boolean flag = true;
            for (int n = j; n < matrix[0].length; n++) {
                for(int k = i; k <=m; k++ ){
                    if(matrix[k][n]!='1') flag = false;
                }
                if(!flag) break;
                sum += m - i + 1;
            }
            if(sum > max) max = sum;
        }

        for (int n = j; n < matrix[0].length; n++) {
            int sum = 0;
            boolean flag = true;
            for (int m = i; m < matrix.length; m++) {
                for(int k = j; k <=n; k++ ){
                    if(matrix[m][k]!='1') flag = false;
                }
                if(!flag) break;
                sum += n - j + 1;
            }
            if(sum > max) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'0', '0', '1', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'},
                {'1', '1', '0', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));
    }
}

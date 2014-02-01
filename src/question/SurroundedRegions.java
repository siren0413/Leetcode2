package question;

import java.util.Arrays;

/**
 * Created by siren0413 on 1/29/14.
 */
public class SurroundedRegions {
    public static void solve(char[][] board){
        if(board.length == 0) return;
        boolean[][] mark = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i==0 ||j==0||i==board.length-1 ||j==board[0].length-1){
                    changeMark(board,i,j,mark);
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j]=='O' && !mark[i][j]) board[i][j]='X';
            }
        }
    }

    private static void changeMark(char[][] board, int i, int j, boolean[][] mark){
        if(i<0||j<0||i>board.length-1 || j > board[0].length-1 || board[i][j]=='X' || mark[i][j]) return;
        if(board[i][j]=='O') mark[i][j] = true;
        changeMark(board,i+1,j,mark);
        changeMark(board,i-1,j,mark);
        changeMark(board,i,j+1,mark);
        changeMark(board,i,j-1,mark);
    }

    public static void main(String[] args){
        char[][] board = {
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'}
        };

        solve(board);
        System.out.println(Arrays.deepToString(board));
    }


}

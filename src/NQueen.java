import java.util.Scanner;
public class NQueen{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nqueen(board,0);
    }
    public static void nqueen(char[][] board, int row){
        int n=board.length;
        for(int j=0;j<n;j++) {
            if (isSafe(board, row, col)) {
                board[row][j]='Q';
                nqueen(board,row+1);
                board[row][j]='X'; //backtracking
            }
        }
        if(row==n){
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            return;
        }
    }
    public static boolean isSafe(char[][] board, int row, int col){
        int n=board.length;
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q') return false;
        }
        f

    }
}
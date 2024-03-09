import java.util.Scanner;
public class NQueen{
    public static int count=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        char[][] board=new char[n][n];
        nqueen(board,0);
    }
    public static void nqueen(char[][] board, int row){
        int n=board[0].length;
        if(row==n){
            count++;
            System.out.println("possibility "+count+": \n");
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j]=='Q')
                    System.out.print(" 👑 ");
                    else
                        System.out.print(" . ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int j=0;j<n;j++) {
            if (isSafe(board, row,j)) {
                board[row][j]='Q';
                nqueen(board,row+1);
                board[row][j]='X'; //backtracking
            }
        }

    }
    public static boolean isSafe(char[][] board, int row, int col){
        int n=board.length;
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q') return false;
        }
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q') return false;
        }
        int i=row;
        int j=col;
        //north east
        while(i>=0&&j<n){
            if(board[i][j]=='Q') return false;
            i--;
            j++;
        }
        i=row;
        j=col;
        //south east
        while(i<n&&j<n){
            if(board[i][j]=='Q') return false;
            i++;
            j++;
        }
        i=row;
        j=col;
        //north west
        while(i>=0&&j>=0){
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
        i=row;
        j=col;
        //south west
        while(i<n&&j>=0){
            if(board[i][j]=='Q') return false;
            i++;
            j--;
        }
        return true;

    }
}
import java.util.Scanner;
 public class nQueens{
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the number of queens : ");
         int n = sc.nextInt();
         char[][] board = new char[n][n];
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 board[i][j]='.';
             }
         }
         nqueen(board,0);
     }
     public static void nqueen(char[][] board, int row){
         int n=board.length;
         if(row==n){
             for(int i=0;i<n;i++){
                 for(int j=0;j<n;j++){
                     System.out.print(board[i][j]+" ");
                 }
                 System.out.println();
             }
             System.out.println("\n\n\n\n");
             return;
         }
         for(int j=0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nqueen(board,row+1);
                board[row][j]='.'; //backtracking
            }
         }

     }
     public static boolean isSafe(char[][] board, int rower, int column){
         int n=board.length;
         for(int j=0;j<n;j++){
             if(board[rower][j]=='Q') return false;
         }
         for(int i=0;i<n;i++){
             if(board[i][column]=='Q') return false;
         }
         int row=rower;
         int col=column;
         while(row>=0 && col<n){
             if(board[row][col]=='Q') return false;
             row--;
             col++;
         }
         row=rower;
         col=column;
         while(row>=0&&col>=0){
             if(board[row][col]=='Q') return false;
             row--;
             col--;
         }
         row=rower;
         col=column;
         while(row<n && col<n){
             if(board[row][col]=='Q') return false;
             row++;
             col++;
         }
         row=rower;
         col=column;
         while(row<n && col>=0){
             if(board[row][col]=='Q') return false;
             row++;
             col--;
         }
         return true;

     }
 }
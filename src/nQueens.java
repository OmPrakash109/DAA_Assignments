//import java.util.Scanner;
// public class nQueens{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of queens : ");
//         int n = sc.nextInt();
//         char[][] board = new char[n][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 board[i][j]='.';
//             }
//         }
//         nqueen(board,0);
//     }
//     public static void nqueen(char[][] board, int row){
//         int n=board.length;
//         if(row==n){
//             for(int i=0;i<n;i++){
//                 for(int j=0;j<n;j++){
//                     System.out.println(board[i][j]);
//                 }
//             }
//             return;
//         }
//         for(int j=0;j<n;j++){
//            if(isSafe(board,row,j)){
//                board[row][j]='Q';
//                nqueen(board,row+1);
//                board[row][j]='X'; //backtracking
//            }
//         }
//
//     }
//     public static boolean isSafe(char[][] board, int row, int col){
//         int n=board.length;
//         for(int j=0;j<n;j++){
//             if(board[row][j]=='Q') return false;
//         }
//         for(int i=0;i<n;i++){
//             if(board[i][col]=='Q') return false;
//         }
//         while(row>=0 && col<n){
//             if(board[row][col]=='Q') return false;
//             row--;
//             col++;
//         }
//         while(row>=0&&col>=0){
//             if(board[row][col]=='Q') return false;
//             row--;
//             col--;
//         }
//         while(row<n && col<n){
//             if(board[row][col]=='Q') return false;
//             row++;
//             col++;
//         }
//         while(row<n && col>=0){
//             if(board[row][col]=='Q') return false;
//             row++;
//             col--;
//         }
//         return true;
//
//     }
// }
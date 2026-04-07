class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        char[][] board=new char[n][n];
        for(char[] ch:board)Arrays.fill(ch,'.');
        backtrack(0,list,board,n);
        return list;
    }
    private void backtrack(int row,List<List<String>> list,char[][] board,int n){
        if(n==row){
            list.add(construct(board));
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                backtrack(row+1,list,board,n);
                board[row][col]='.';
            }
        }
    }
    private boolean isSafe(int row,int col,char[][] board,int n){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q')return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q')return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q')return false;
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> st=new ArrayList<>();
        for(char[] ch:board){
            st.add(new String(ch));
        }
        return st;
    }
}

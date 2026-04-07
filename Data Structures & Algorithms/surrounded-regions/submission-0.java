class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
        for(int i=0;i<m;i++){
            dfs(board,0,i);
            dfs(board,n-1,i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='T')board[i][j]='O';
            }
        }
    }
    private void dfs(char[][] board,int r,int c){
        if(r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]!='O')return;
        board[r][c]='T';
        dfs(board,r-1,c);
        dfs(board,r+1,c);
        dfs(board,r,c-1);
        dfs(board,r,c+1);
    }
}

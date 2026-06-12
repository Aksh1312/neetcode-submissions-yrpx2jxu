class Solution {
    int m,n;
    int[][] dp;
    int[][] matrix;
    int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
    public int dfs(int i,int j){
        if(dp[i][j]!=0)return dp[i][j];
        int best=1;
        for(int[] d:dir){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni>=0&&ni<n&&nj>=0&&nj<m&&matrix[ni][nj]>matrix[i][j]){
                best=Math.max(1+dfs(ni,nj),best);
            }
        }
        return dp[i][j]=best;
    }
    public int longestIncreasingPath(int[][] matrix) {
        this.n=matrix.length;
        this.m=matrix[0].length;
        this.matrix=matrix;
        dp=new int[n][m];
        int best=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                best=Math.max(best,dfs(i,j));
            }
        }
        return best;
    }
}

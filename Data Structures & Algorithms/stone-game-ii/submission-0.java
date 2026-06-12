class Solution {
    int[][] dp;
    int total;
    int[] suffix;
    public int solve(int i,int M,int[] piles){
        int n=piles.length;
        if(i>=n)return 0;
        if(dp[i][M]!=0)return dp[i][M];
        int best=0;
        for(int x=1;x<=2*M&&i+x<=n;x++){
            int opp=solve(i+x,Math.max(x,M),piles);
            best=Math.max(best,suffix[i]-opp);
        }
        return dp[i][M]=best;
    }
    public int stoneGameII(int[] piles) {
        suffix=new int[piles.length];
        suffix[piles.length-1]=piles[piles.length-1];
        for(int i=piles.length-2;i>=0;i--)suffix[i]=suffix[i+1]+piles[i];
        int n=piles.length;
        dp=new int[n][n+1];
        return solve(0,1,piles);
    }
}
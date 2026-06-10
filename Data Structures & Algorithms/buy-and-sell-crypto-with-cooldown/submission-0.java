class Solution {
    int[][] dp;
    public int fun(int ind,int buy,int[] prices){
        if(ind>=prices.length)return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        if(buy==1)dp[ind][buy]=Math.max(-prices[ind]+fun(ind+1,0,prices),fun(ind+1,1,prices));
        else dp[ind][buy]=Math.max(prices[ind]+fun(ind+2,1,prices),fun(ind+1,0,prices));
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++)Arrays.fill(dp[i],-1);
        return fun(0,1,prices);
    }
}

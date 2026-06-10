class Solution {
    int[][] dp;
    public int fun(int target,int[] coins,int ind){
        if(ind==0){
            if(target%coins[0]==0)return 1;
            return 0;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];
        int nottake=fun(target,coins,ind-1);
        int take=0;
        if(coins[ind]<=target)take=fun(target-coins[ind],coins,ind);
        return dp[ind][target]=nottake+take;
    }
    public int change(int amount, int[] coins) {
        dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(amount,coins,coins.length-1);
    }
}

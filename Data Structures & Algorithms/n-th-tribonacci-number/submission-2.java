class Solution {
    int[] dp;
    public int tri(int n){
        if(n==0)return 0;
        if(n==1||n==2)return 1;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=tri(n-3)+tri(n-1)+tri(n-2);
    }
    public int tribonacci(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return tri(n);
    }
}
class Solution {
    int[][] dp;
    public int fun(int ind,int sum,int[] nums,int target){
        if(ind==nums.length)return sum==target?1:0;
        if(dp[ind][sum+200000]!=-1)return dp[ind][sum+200000];
        int plus=fun(ind+1,sum+nums[ind],nums,target);
        int minus=fun(ind+1,sum-nums[ind],nums,target);
        return dp[ind][sum+200000]=plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        dp=new int[nums.length+1][400001];
        for(int i=0;i<nums.length;i++)Arrays.fill(dp[i],-1);
        return fun(0,0,nums,target);
    }
}

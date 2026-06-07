class Solution {
    public boolean canPartition(int[] nums) {
        int sums=0;
        for(int i=0;i<nums.length;i++){
            sums+=nums[i];
        }
        if(sums%2!=0)return false;
        int target=sums/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int num:nums){
            for(int sum=target;sum>=num;sum--){
                dp[sum]=dp[sum]||dp[sum-num];
            }
        }
        return dp[target];
    }
}

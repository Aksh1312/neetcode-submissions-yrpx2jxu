class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currSum=nums[0],maxSum=nums[0],minSum=nums[0],currMin=nums[0],tot=nums[0];
        for(int i=1;i<nums.length;i++){
            currSum=Math.max(nums[i],nums[i]+currSum);
            maxSum=Math.max(maxSum,currSum);
            currMin=Math.min(nums[i],nums[i]+currMin);
            minSum=Math.min(minSum,currMin);
            tot+=nums[i];
        }
        if(maxSum<0)return maxSum;
        return Math.max(tot-minSum,maxSum);
    }
}
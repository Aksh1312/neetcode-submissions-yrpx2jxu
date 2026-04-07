class Solution {
    public boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)return  true;
            if(nums[mid]==nums[left]&&nums[mid]==nums[right]){
                left++;right--;
            }
            else if(nums[left]<=nums[mid]){
                if(nums[left]<=target&&nums[mid]>target){
                    right=mid-1;
                }
                else left=mid+1;
            }
            else{
                if(nums[right]>=target&&nums[mid]<target){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return false;       
    }
}
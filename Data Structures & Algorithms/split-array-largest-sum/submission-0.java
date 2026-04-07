class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int a:nums){
            low=Math.max(low,a);
            high+=a;
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(canSplit(nums,k,mid)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean canSplit(int[] nums,int k,int mid){
        int count=1,sum=0;
        for(int a:nums){
            if(sum+a>mid){
                count++;
                sum=a;
                if(count>k)return false;
            }
            else{
                sum+=a;
            }
        }
        return true;
    }
}
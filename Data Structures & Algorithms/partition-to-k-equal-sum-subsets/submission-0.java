class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total=0;
        for(int i:nums)total+=i;
        if(total%k!=0)return false;
        int target=total/k;
        Arrays.sort(nums);
        if(nums[nums.length-1]>target)return false;
        boolean[] bool=new boolean[nums.length];
        return part(nums,bool,0,0,k,target);
    }
    private boolean part(int[] nums,boolean[] used,int start,int sum,int k,int target){
        if(k==1)return true;
        if(sum==target){
            return part(nums,used,0,0,k-1,target);
        }
        for(int i=start;i<nums.length;i++){
            if(used[i]||sum+nums[i]>target)continue;
            used[i]=true;
            if(part(nums,used,i+1,sum+nums[i],k,target))return true;
            used[i]=false;
            if(sum==0)break;
        }
        return false;
    }
}
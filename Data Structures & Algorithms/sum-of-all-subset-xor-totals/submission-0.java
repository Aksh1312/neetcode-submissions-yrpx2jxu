class Solution {
    int sum=0;
    public int subsetXORSum(int[] nums) {
        xor(nums,0,0);
        return sum;
    }
    private void xor(int[] nums,int index,int xr){
        if(index==nums.length){
            sum+=xr;
            return;
        }
        xor(nums,index+1,xr^nums[index]);
        xor(nums,index+1,xr);
    }
}
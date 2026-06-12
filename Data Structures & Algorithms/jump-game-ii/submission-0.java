class Solution {
    public int jump(int[] nums) {
        int max=0,curr=0,jump=0;
        for(int i=0;i<nums.length-1;i++){
            max=Math.max(max,i+nums[i]);
            if(i==curr){
                jump++;
                curr=max;
            }
        }
        return jump;
    }
}

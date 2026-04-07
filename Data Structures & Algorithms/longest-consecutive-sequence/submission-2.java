class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            int length=1;
            int current=nums[i];
            while(set.contains(current+1)){
                length++;
                current++;
            }
            if(max<length)max=length;
        }
        return max;
    }
}

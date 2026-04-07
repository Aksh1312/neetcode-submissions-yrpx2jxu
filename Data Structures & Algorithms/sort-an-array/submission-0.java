class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i:nums){
            queue.add(i);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=queue.poll();
        }
        return nums;
    }
}
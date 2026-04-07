class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        sum(nums,target,0,new ArrayList<>(),result);
        return result;
    }
    private void sum(int[] nums,int target,int index,List<Integer> current,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0)return;
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            sum(nums,target-nums[i],i,current,result);
            current.remove(current.size()-1);
        }
    }
}

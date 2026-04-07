class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0,count=0;
        for(int num:nums){
            sum+=num;
            int a=sum-k;
            if(map.containsKey(a)){
                count+=map.get(a);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
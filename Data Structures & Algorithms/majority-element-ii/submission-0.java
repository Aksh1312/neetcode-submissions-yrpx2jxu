class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> ans=new ArrayList<>();
        int a=nums.length/3,l=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>a){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
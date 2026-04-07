class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> a=new ArrayList<>();
        int l=0;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> entry=new ArrayList<>(map.entrySet());
        entry.sort((p,b)->b.getValue()-p.getValue());
        Map.Entry<Integer,Integer> max=entry.get(0);
        return max.getKey();
    }
}

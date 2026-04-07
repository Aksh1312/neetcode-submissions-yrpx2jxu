class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> a=new ArrayList<>();
        int l=0;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> entry=new ArrayList<>(map.entrySet());
        entry.sort((p,b)->b.getValue()-p.getValue());
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=entry.get(i).getKey();
        }
        return ans;
    }
}

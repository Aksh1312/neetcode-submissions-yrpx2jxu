class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:hand)map.put(n,map.getOrDefault(n,0)+1);
        Arrays.sort(hand);
        for(int q:hand){
            if(map.get(q)==0)continue;
            for(int i=0;i<groupSize;i++){
                int curr=q+i;
                if(map.getOrDefault(curr,0)==0)return false;
                map.put(curr,map.get(curr)-1);
            }
        }
        return true;
    }
}

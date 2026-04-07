class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> a=new HashSet<>();
        int maxlen=0;
        for(int num:nums){
            a.add(num);
        }
        for(int num:nums){
            if(!a.contains(num-1)){
                int current=num;
                int count=1;
                while(a.contains(current+1)){
                    current++;
                    count++;
                }
                maxlen=Math.max(maxlen,count);
            }
        }
        return maxlen;
    }
}

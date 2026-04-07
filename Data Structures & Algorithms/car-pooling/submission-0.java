class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff=new int[1001];
        for(int i=0;i<trips.length;i++){
            int num=trips[i][0];
            int src=trips[i][1];
            int dest=trips[i][2];
            diff[src]+=num;
            diff[dest]-=num;
        }
        int cap=0;
        for(int i=0;i<1001;i++){
            cap+=diff[i];
            if(cap>capacity)return false;
        }
        return true;
    }
}
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int a:piles)max=Math.max(max,a);
        int left=1;
        int right=max;
        int curr=0;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canEat(piles,h,mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean canEat(int[] piles,int h,int k){
        int hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=Math.ceil((double)piles[i]/k);
        }
        return hours<=h;
    }
}

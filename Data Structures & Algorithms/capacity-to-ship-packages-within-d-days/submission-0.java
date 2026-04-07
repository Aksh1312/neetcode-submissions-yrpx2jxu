class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0,right=0;
        for(int a:weights){
            left=Math.max(left,a);
            right+=a;
        }
        while(left<right){
            int mid=(left+right)/2,d=1,curr=0;
            for(int a:weights){
                if(curr+a>mid){
                    d++;
                    curr=0;
                }
                curr+=a;
            }
            if(d<=days)right=mid;
            else left=mid+1;
        }
        return left;
    }
}
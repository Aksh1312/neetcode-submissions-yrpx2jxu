/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        int peek=peek(mountainArr,n);
        int ind=binary(mountainArr,0,peek,target,true);
        if(ind!=-1)return ind;
        return binary(mountainArr,peek+1,n-1,target,false);
    }
    public int peek(MountainArray arr,int n){
        int low=0,high=n-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr.get(mid)<arr.get(mid+1)){
                low=mid+1;
            }
            else high=mid;
        }
        return low;
    }
    public int binary(MountainArray arr,int low,int high,int target,boolean ding){
        while(low<=high){
            int mid=low+(high-low)/2;
            int val=arr.get(mid);
            if(val==target)return mid;
            if(ding){
                if(val<target)low=mid+1;
                else high=mid-1;
            }
            else{
                if(val>target)low=mid+1;
                else high=mid-1;
            }
        }
        return -1;
    }
}
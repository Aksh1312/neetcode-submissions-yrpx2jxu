class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=m-1;
        int q=n-1;
        int m1=m+n-1;
        while(p>=0&&q>=0){
            if(nums1[p]<nums2[q]){
                nums1[m1]=nums2[q];
                q--;
            }
            else{
                nums1[m1]=nums1[p];
                p--;
            }
            m1--;
        }
        while(q>=0){
            nums1[m1--]=nums2[q--];
        }
    }
}
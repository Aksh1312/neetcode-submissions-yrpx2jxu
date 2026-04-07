class Solution {
    public int[] sortArray(int[] nums) {
        heapsort(nums);
        return nums;
    }
    private void heapsort(int[] nums){
        int n=nums.length;
        for(int i=(n/2)-1;i>=0;i--){
            heapify(nums,n,i);
        }
        for(int i=n-1;i>0;i--){
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            heapify(nums,i,0);
        }
    }
    private void heapify(int[] nums,int n,int i){
        int largest=i;
        int right=i*2+2;
        int left=i*2+1;
        if(left<n&&nums[left]>nums[largest])largest=left;
        if(right<n&&nums[right]>nums[largest])largest=right;
        if(i!=largest){
            int temp=nums[largest];
            nums[largest]=nums[i];
            nums[i]=temp;
            heapify(nums,n,largest);
        }
    }
}
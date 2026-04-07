class Solution {
    public int trap(int[] height) {
        int area=0;
        int leftmax=0,rightmax=0,left=0,right=height.length-1;
        while(left<right){
            if(height[left]<height[right]){
                if(leftmax<height[left])leftmax=height[left];
                area+=leftmax-height[left];
                left++;
            }
            else{
                if(rightmax<height[right])rightmax=height[right];
                area+=rightmax-height[right];
                right--;
            }
        }
        return area;
    }
}

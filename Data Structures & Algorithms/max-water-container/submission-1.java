class Solution {
    public int maxArea(int[] heights) {
        int left=0,right=heights.length-1;
        int max=0;
        while(left<right){
            int length=right-left;
            int width=Math.min(heights[right],heights[left]);
            int area=length*width;
            if(area>max)max=area;
            if(heights[left]<heights[right])left++;
            else right--;
        }
        return max;
    }
}

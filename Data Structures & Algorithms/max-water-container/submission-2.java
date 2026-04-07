class Solution {
    public int maxArea(int[] heights) {
        int left=0,right=heights.length-1,maxarea=0;
        while(left<right){
            int length=right-left;
            int width=Math.min(heights[left],heights[right]);
            int area=length*width;
            if(maxarea<area)maxarea=area;
            if(heights[left]<heights[right])left++;
            else right--;
        }
        return maxarea;
    }
}

class Solution {
    public int maxArea(int[] heights) {
        int left=0,end=heights.length-1,maxarea=0;
        while(left<end){
            int width=end-left;
            int height=Math.min(heights[end],heights[left]);
            int area=width*height;
            maxarea=Math.max(maxarea,area);
            if(heights[left]<heights[end])left++;
            else end--;
        }
        return maxarea;
    }
}

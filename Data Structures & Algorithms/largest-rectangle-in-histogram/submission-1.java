class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int max=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty()&&heights[i]<heights[stk.peek()]){
                int height=heights[stk.pop()];
                int width=stk.isEmpty()?i:i-stk.peek()-1;
                max=Math.max(max,height*width);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int height=heights[stk.pop()];
            int width=stk.isEmpty()?n:n-stk.peek()-1;
            max=Math.max(max,height*width);
        }
        return max;
    }
}

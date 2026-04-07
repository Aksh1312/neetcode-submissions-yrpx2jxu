class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> stk=new Stack<>();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            while(!stk.isEmpty()&&temperatures[i]>temperatures[stk.peek()]){
                int part=stk.pop();
                result[part]=i-part;
            }
            stk.push(i);
        }
        return result;
    }
}

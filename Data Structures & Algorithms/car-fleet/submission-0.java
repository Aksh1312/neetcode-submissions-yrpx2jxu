class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] arr=new double[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=position[i];
            arr[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(arr,(a,b)->Double.compare(b[0],a[0]));
        Stack<Double> stk=new Stack<>();
        stk.push(arr[0][1]);
        for(int i=1;i<n;i++){
            if(!stk.isEmpty()&&arr[i][1]>stk.peek()){
                stk.push(arr[i][1]);
            }
        }
        return stk.size();
    }
}
